document.addEventListener("DOMContentLoaded", () => {

    const navBtns = document.querySelectorAll('.nav-btn');
    const panels = document.querySelectorAll('.panel');

    navBtns.forEach(btn => {
        btn.addEventListener('click', () => {
            navBtns.forEach(b => b.classList.remove('active'));
            panels.forEach(p => p.classList.remove('active'));
            btn.classList.add('active');
            const targetPanelId = btn.id.replace('btn-', 'panel-');
            document.getElementById(targetPanelId).classList.add('active');
        });
    });

    const urlVehiculos = 'http://localhost:8080/api/v1/vehiculos';
    const formVehiculo = document.getElementById("form-vehiculo");
    const tbodyVehiculos = document.querySelector('#tabla-vehiculos tbody');
    const btnLimpiar = document.getElementById("btn-limpiar");
    const btnSubmit = document.querySelector("#form-vehiculo button[type='submit']");

    let vehiculosGlobal = [];

    const inputDominio = document.getElementById("dominio");
    const inputColor = document.getElementById("color");

    inputDominio.addEventListener("input", function(e) {
        this.value = this.value.toUpperCase();
        this.value = this.value.replace(/[^A-Z0-9]/g, '');
    });

    inputColor.addEventListener("input", function(e) {
        this.value = this.value.replace(/[0-9]/g, '');
    });

    window.cargarVehiculos = async function() {
        try {
            const respuesta = await fetch(urlVehiculos);
            vehiculosGlobal = await respuesta.json();

            tbodyVehiculos.innerHTML = '';

            if (vehiculosGlobal.length === 0) {
                tbodyVehiculos.innerHTML = '<tr><td colspan="6" class="empty-msg">No hay vehículos registrados.</td></tr>';
                return;
            }

            vehiculosGlobal.forEach(v => {
                const nombreMarca = v.marcaAuto ? v.marcaAuto.marcaAuto : '-';
                const nombreModelo = (v.marcaAuto && v.marcaAuto.modeloAuto) ? v.marcaAuto.modeloAuto.modeloAuto : '-';

                tbodyVehiculos.innerHTML += `
                    <tr>
                        <td><strong>${v.dominio}</strong></td>
                        <td>${nombreMarca}</td>
                        <td>${nombreModelo}</td>
                        <td>${v.color}</td>
                        <td>${v.anioPatentamiento}</td>
                        <td style="display: flex; gap: 5px;">
                            <button class="btn btn-secondary" onclick="prepararEdicion(${v.id})" style="padding: 5px;">Editar</button>
                            <button class="btn btn-danger" onclick="eliminarVehiculo(${v.id})" style="padding: 5px;">Eliminar</button>
                        </td>
                    </tr>
                `;
            });
        } catch (error) {
            console.error(error);
            tbodyVehiculos.innerHTML = '<tr><td colspan="6" class="empty-msg" style="color: red;">Error de conexión</td></tr>';
        }
    }

    formVehiculo.addEventListener("submit", async (e) => {
        e.preventDefault();

        const vehiculoId = document.getElementById("vehiculo-id").value;
        const esEdicion = vehiculoId !== "";

        const vehiculoData = {
            dominio: document.getElementById("dominio").value,
            color: document.getElementById("color").value,
            anioPatentamiento: document.getElementById("anio").value,
            marcaAuto: {
                marcaAuto: document.getElementById("marcaText").value,
                modeloAuto: {
                    modeloAuto: document.getElementById("modeloText").value
                }
            }
        };

        try {
            let urlDestino = urlVehiculos;
            let metodoHTTP = 'POST';

            if (esEdicion) {
                urlDestino = `${urlVehiculos}/${vehiculoId}`;
                metodoHTTP = 'PUT';
                vehiculoData.id = parseInt(vehiculoId);
            }

            await fetch(urlDestino, {
                method: metodoHTTP,
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(vehiculoData)
            });

            limpiarFormulario();
            cargarVehiculos();
            Swal.fire({ position: 'center', icon: 'success', title: '¡Vehículo guardado!', showConfirmButton: false, timer: 2000 });

        } catch (error) {
            Swal.fire({ icon: 'error', title: 'Error', text: 'Hubo un error al guardar/actualizar el vehículo.' });
            console.error(error);
        }
    });

    window.prepararEdicion = function(id) {
        const vehiculo = vehiculosGlobal.find(v => v.id === id);
        if (vehiculo) {
            document.getElementById("vehiculo-id").value = vehiculo.id;
            document.getElementById("dominio").value = vehiculo.dominio;
            document.getElementById("color").value = vehiculo.color;
            document.getElementById("anio").value = vehiculo.anioPatentamiento;
            document.getElementById("marcaText").value = vehiculo.marcaAuto ? vehiculo.marcaAuto.marcaAuto : '';
            document.getElementById("modeloText").value = (vehiculo.marcaAuto && vehiculo.marcaAuto.modeloAuto) ? vehiculo.marcaAuto.modeloAuto.modeloAuto : '';

            btnSubmit.textContent = "Actualizar Vehículo";
            btnSubmit.classList.add("btn-primary");
        }
    }

    window.eliminarVehiculo = async function(id) {
        const confirmacion = await Swal.fire({
            title: '¿Estás seguro?',
            text: "No vas a poder revertir esta acción.",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Sí, eliminar',
            cancelButtonText: 'Cancelar'
        });

        if (confirmacion.isConfirmed) {
            try {
                const respuesta = await fetch(`${urlVehiculos}/${id}`, {
                    method: 'DELETE'
                });

                if (!respuesta.ok) throw new Error();

                cargarVehiculos();
                Swal.fire('¡Eliminado!', 'El vehículo ha sido borrado.', 'success');
            } catch (error) {
                Swal.fire({
                    icon: 'error',
                    title: 'No se puede eliminar',
                    text: 'Es posible que este vehículo tenga un Acta vinculada a su patente.'
                });
                console.error(error);
            }
        }
    }

    function limpiarFormulario() {
        formVehiculo.reset();
        document.getElementById("vehiculo-id").value = "";
        btnSubmit.textContent = "Guardar Vehículo";
    }

    btnLimpiar.addEventListener("click", limpiarFormulario);

    cargarVehiculos();

    const urlConductores = 'http://localhost:8080/api/v1/conductores';
    const formConductor = document.getElementById("form-conductor");
    const tbodyConductores = document.querySelector('#tabla-conductores tbody');
    const btnLimpiarConductor = document.getElementById("btn-limpiar-conductor");
    const btnSubmitConductor = document.getElementById("btn-submit-conductor");

    let conductoresGlobal = [];

    window.cargarConductores = async function() {
        try {
            const respuesta = await fetch(urlConductores);
            conductoresGlobal = await respuesta.json();

            tbodyConductores.innerHTML = '';

            if (conductoresGlobal.length === 0) {
                tbodyConductores.innerHTML = '<tr><td colspan="4" class="empty-msg">No hay conductores registrados.</td></tr>';
                return;
            }

            conductoresGlobal.forEach(c => {
                tbodyConductores.innerHTML += `
                    <tr>
                        <td><strong>${c.dni}</strong></td>
                        <td>${c.nombre}</td>
                        <td>${c.apellido}</td>
                        <td style="display: flex; gap: 5px;">
                            <button class="btn btn-secondary" onclick="prepararEdicionConductor(${c.id})" style="padding: 5px;">Editar</button>
                            <button class="btn btn-danger" onclick="eliminarConductor(${c.id})" style="padding: 5px;">Eliminar</button>
                        </td>
                    </tr>
                `;
            });
        } catch (error) {
            console.error(error);
            tbodyConductores.innerHTML = '<tr><td colspan="4" class="empty-msg" style="color: red;">Error de conexión</td></tr>';
        }
    }

    formConductor.addEventListener("submit", async (e) => {
        e.preventDefault();

        const conductorId = document.getElementById("conductor-id").value;
        const esEdicion = conductorId !== "";

        const conductorData = {
            dni: document.getElementById("dni").value,
            nombre: document.getElementById("nombre").value,
            apellido: document.getElementById("apellido").value
        };

        try {
            let urlDestino = urlConductores;
            let metodoHTTP = 'POST';

            if (esEdicion) {
                urlDestino = `${urlConductores}/${conductorId}`;
                metodoHTTP = 'PUT';
                conductorData.id = parseInt(conductorId);
            }

            const respuestaCond = await fetch(urlDestino, {
                method: metodoHTTP,
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(conductorData)
            });

            if (!respuestaCond.ok) throw new Error(await respuestaCond.text());

            const conductorGuardado = await respuestaCond.json();

            if (!esEdicion) {
                const licenciaData = {
                    numeroLicencia: document.getElementById("licencia").value,
                    conductor: { id: conductorGuardado.id }
                };

                const respuestaLic = await fetch('http://localhost:8080/api/v1/licencias', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(licenciaData)
                });

                if (!respuestaLic.ok) throw new Error(await respuestaLic.text());
            }

            limpiarFormularioConductor();
            cargarConductores();
            Swal.fire({ position: 'center', icon: 'success', title: '¡Conductor y Licencia guardados!', showConfirmButton: false, timer: 2000 });

        } catch (error) {
            Swal.fire({ icon: 'error', title: 'Error', text: 'Hubo un error en el proceso. Revisá la consola.' });
            console.error(error);
        }
    });

    window.prepararEdicionConductor = function(id) {
        const conductor = conductoresGlobal.find(c => c.id === id);
        if (conductor) {
            document.getElementById("conductor-id").value = conductor.id;
            document.getElementById("dni").value = conductor.dni;
            document.getElementById("nombre").value = conductor.nombre;
            document.getElementById("apellido").value = conductor.apellido;
            document.getElementById("licencia").value = conductor.numeroLicencia || '';

            btnSubmitConductor.textContent = "Actualizar Conductor";
            btnSubmitConductor.classList.add("btn-primary");
        }
    }

    window.eliminarConductor = async function(id) {
        const confirmacion = await Swal.fire({
            title: '¿Eliminar conductor?',
            text: "También se eliminará su licencia asociada.",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Sí, eliminar',
            cancelButtonText: 'Cancelar'
        });

        if (confirmacion.isConfirmed) {
            try {
                const resLicencias = await fetch('http://localhost:8080/api/v1/licencias');
                const licencias = await resLicencias.json();
                const licenciaAsociada = licencias.find(l => l.conductor && l.conductor.id === id);

                if (licenciaAsociada) {
                    const resBorrarLic = await fetch(`http://localhost:8080/api/v1/licencias/${licenciaAsociada.id}`, {
                        method: 'DELETE'
                    });
                    if (!resBorrarLic.ok) throw new Error();
                }

                const resBorrarCond = await fetch(`${urlConductores}/${id}`, {
                    method: 'DELETE'
                });

                if (!resBorrarCond.ok) throw new Error();

                cargarConductores();
                Swal.fire('¡Eliminado!', 'El conductor ha sido borrado.', 'success');
            } catch (error) {
                Swal.fire({ icon: 'error', title: 'No se puede eliminar', text: 'Es posible que tenga un Acta vinculada a su nombre.' });
                console.error(error);
            }
        }
    }

    function limpiarFormularioConductor() {
        formConductor.reset();
        document.getElementById("conductor-id").value = "";
        btnSubmitConductor.textContent = "Guardar Conductor";
    }

    btnLimpiarConductor.addEventListener("click", limpiarFormularioConductor);

    const inputDni = document.getElementById("dni");
    const inputsTexto = [document.getElementById("nombre"), document.getElementById("apellido")];
    const inputLicencia = document.getElementById("licencia");

    inputLicencia.addEventListener("input", function() {
        this.value = this.value.replace(/[^0-9]/g, '');
    });

    inputDni.addEventListener("input", function() {
        this.value = this.value.replace(/[^0-9]/g, '');
    });

    inputsTexto.forEach(input => {
        input.addEventListener("input", function() {
            this.value = this.value.replace(/[0-9]/g, '');
        });
    });

    cargarConductores();

    const urlActas = 'http://localhost:8080/api/v1/actas';
    const urlAutoridades = 'http://localhost:8080/api/v1/autoridades';

    const formActa = document.getElementById("form-acta");
    const tbodyActas = document.querySelector('#tabla-actas tbody');
    const selectVehiculo = document.getElementById("select-vehiculo");
    const selectConductor = document.getElementById("select-conductor");
    const selectAutoridad = document.getElementById("select-autoridad");

    window.cargarDesplegablesActa = async function() {
        try {
            const resVehiculos = await fetch(urlVehiculos);
            const vehiculos = await resVehiculos.json();
            selectVehiculo.innerHTML = '<option value="">Seleccione un vehículo...</option>';
            vehiculos.forEach(v => {
                selectVehiculo.innerHTML += `<option value="${v.id}">${v.dominio} - ${v.marcaAuto?.marcaAuto || 'Sin marca'}</option>`;
            });

            const resLicencias = await fetch('http://localhost:8080/api/v1/licencias');
            const licencias = await resLicencias.json();

            selectConductor.innerHTML = '<option value="">Seleccione una licencia...</option>';
            licencias.forEach(l => {
                const nombreChofer = l.conductor ? `${l.conductor.apellido}, ${l.conductor.nombre}` : 'Sin datos';
                selectConductor.innerHTML += `<option value="${l.id}">Lic: ${l.numeroLicencia} - ${nombreChofer}</option>`;
            });

            const resAutoridades = await fetch(urlAutoridades);
            const autoridades = await resAutoridades.json();
            selectAutoridad.innerHTML = '<option value="">Seleccione una autoridad...</option>';
            autoridades.forEach(a => {
                selectAutoridad.innerHTML += `<option value="${a.id}">Placa: ${a.idPlaca} - ${a.nombre} ${a.apellido}</option>`;
            });

        } catch (error) {
            console.error(error);
        }
    }

    window.cargarActas = async function() {
        try {
            const respuesta = await fetch(urlActas);
            const actas = await respuesta.json();

            tbodyActas.innerHTML = '';

            if (actas.length === 0) {
                tbodyActas.innerHTML = '<tr><td colspan="6" class="empty-msg">No hay actas registradas.</td></tr>';
                return;
            }

            actas.forEach(a => {
                const patente = a.vehiculo ? a.vehiculo.dominio : 'N/A';
                const conductorId = a.licencias ? a.licencias.id : 'N/A';

                const detalleInfraccion = (a.mInfraccion && a.mInfraccion.length > 0)
                    ? a.mInfraccion[0].descripInfraccion
                    : 'Sin detalle';

                tbodyActas.innerHTML += `
                    <tr>
                        <td><strong>${a.fechaDeLabrado}</strong></td>
                        <td>${patente}</td>
                        <td>ID: ${conductorId}</td>
                        <td>${a.lugarDeConstatacion}</td>
                        <td>${detalleInfraccion}</td>
                        <td>
                            <button class="btn btn-danger" onclick="eliminarActa(${a.id})" style="padding: 5px;">Eliminar</button>
                        </td>
                    </tr>
                `;
            });
        } catch (error) {
            console.error(error);
            tbodyActas.innerHTML = '<tr><td colspan="6" class="empty-msg" style="color: red;">Error de conexión</td></tr>';
        }
    }

    formActa.addEventListener("submit", async (e) => {
        e.preventDefault();

        let horaStr = document.getElementById("horaLabrado").value;
        if (horaStr.length === 5) horaStr += ":00";

        const vehiculoVal = document.getElementById("select-vehiculo").value;
        const conductorVal = document.getElementById("select-conductor").value;
        const autoridadVal = document.getElementById("select-autoridad").value;

        if (!vehiculoVal || vehiculoVal === "undefined" ||
            !conductorVal || conductorVal === "undefined" ||
            !autoridadVal || autoridadVal === "undefined") {
            Swal.fire({ icon: 'warning', title: 'Faltan datos', text: 'Asegurate de seleccionar Vehículo, Conductor y Autoridad.' });
            return;
        }

        const nuevaActa = {
            fechaDeLabrado: document.getElementById("fechaLabrado").value,
            horaDeLabrado: horaStr,
            lugarDeConstatacion: document.getElementById("lugarConstatacion").value,
            observaciones: document.getElementById("observaciones").value,
            vehiculo: { id: parseInt(vehiculoVal) },
            licencias: { id: parseInt(conductorVal) },
            autoridadDeConstatacion: { id: parseInt(autoridadVal) },
            mInfraccion: [
                {
                    descripInfraccion: document.getElementById("descripInfraccion").value,
                    importeInfraccion: document.getElementById("importeInfraccion") ? parseFloat(document.getElementById("importeInfraccion").value) : 0.0
                }
            ]
        };

        try {
            const respuesta = await fetch(urlActas, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(nuevaActa)
            });

            if (!respuesta.ok) {
                const errorBackend = await respuesta.text();
                throw new Error(errorBackend);
            }

            formActa.reset();
            cargarActas();

            Swal.fire({ position: 'center', icon: 'success', title: '¡Acta labrada con éxito!', showConfirmButton: false, timer: 2000 });

        } catch (error) {
            Swal.fire({ icon: 'error', title: 'Error en el servidor', text: 'El servidor rechazó el acta. Verificá los datos ingresados.' });
            console.error(error);
        }
    });

    window.eliminarActa = async function(id) {
        const confirmacion = await Swal.fire({
            title: '¿Anular acta?',
            text: "Esta acción no se puede deshacer.",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Sí, anular',
            cancelButtonText: 'Cancelar'
        });

        if (confirmacion.isConfirmed) {
            try {
                await fetch(`${urlActas}/${id}`, { method: 'DELETE' });
                cargarActas();
                Swal.fire('¡Anulada!', 'El acta ha sido eliminada.', 'success');
            } catch (error) {
                Swal.fire({ icon: 'error', title: 'Error', text: 'No se pudo eliminar el acta.' });
                console.error(error);
            }
        }
    }

    document.getElementById("btn-actas").addEventListener("click", () => {
        cargarDesplegablesActa();
        cargarActas();
    });

    document.getElementById("btn-limpiar-acta").addEventListener("click", () => formActa.reset());

    const formAutoridad = document.getElementById("form-autoridad");
    const tbodyAutoridades = document.querySelector('#tabla-autoridades tbody');

    window.cargarAutoridades = async function() {
        try {
            const respuesta = await fetch(urlAutoridades);
            const autoridades = await respuesta.json();

            tbodyAutoridades.innerHTML = '';

            if (autoridades.length === 0) {
                tbodyAutoridades.innerHTML = '<tr><td colspan="4" class="empty-msg">No hay oficiales registrados.</td></tr>';
                return;
            }

            autoridades.forEach(a => {
                tbodyAutoridades.innerHTML += `
                    <tr>
                        <td><strong>${a.apellido}, ${a.nombre}</strong> <br><small>DNI: ${a.dni}</small></td>
                        <td>${a.idPlaca}</td>
                        <td>${a.idLegajo}</td>
                        <td>
                            <button class="btn btn-danger" onclick="eliminarAutoridad(${a.id})" style="padding: 5px;">Eliminar</button>
                        </td>
                    </tr>
                `;
            });
        } catch (error) {
            console.error(error);
        }
    }

    formAutoridad.addEventListener("submit", async (e) => {
        e.preventDefault();

        const nuevaAutoridad = {
            dni: document.getElementById("aut-dni").value,
            nombre: document.getElementById("aut-nombre").value,
            apellido: document.getElementById("aut-apellido").value,
            idPlaca: parseInt(document.getElementById("aut-placa").value),
            idLegajo: parseInt(document.getElementById("aut-legajo").value)
        };

        try {
            await fetch(urlAutoridades, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(nuevaAutoridad)
            });

            formAutoridad.reset();
            cargarAutoridades();
            Swal.fire({ position: 'center', icon: 'success', title: '¡Autoridad guardada!', showConfirmButton: false, timer: 2000 });

        } catch (error) {
            Swal.fire({ icon: 'error', title: 'Error', text: 'Hubo un error al guardar la autoridad.' });
        }
    });

    window.eliminarAutoridad = async function(id) {
        const confirmacion = await Swal.fire({
            title: '¿Dar de baja oficial?',
            text: "No podrás revertir esto.",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Sí, eliminar',
            cancelButtonText: 'Cancelar'
        });

        if (confirmacion.isConfirmed) {
            try {
                const respuesta = await fetch(`${urlAutoridades}/${id}`, { method: 'DELETE' });
                if (!respuesta.ok) throw new Error();
                cargarAutoridades();
                Swal.fire('¡Eliminado!', 'El oficial ha sido dado de baja.', 'success');
            } catch (error) {
                Swal.fire({ icon: 'error', title: 'No se puede eliminar', text: 'Es posible que tenga un Acta vinculada a su nombre.' });
            }
        }
    }

    document.getElementById("aut-dni").addEventListener("input", function() {
        this.value = this.value.replace(/[^0-9]/g, '');
    });

    document.getElementById("aut-nombre").addEventListener("input", function() {
        this.value = this.value.replace(/[0-9]/g, '');
    });

    document.getElementById("aut-apellido").addEventListener("input", function() {
        this.value = this.value.replace(/[0-9]/g, '');
    });

    document.getElementById("btn-autoridades").addEventListener("click", cargarAutoridades);

    cargarAutoridades();
});