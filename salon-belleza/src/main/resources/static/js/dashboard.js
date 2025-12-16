// -------------------------------------------
// CAMBIAR SECCIÓN
// -------------------------------------------
function mostrarSeccion(id, boton) {

    // Ocultar todas las secciones
    document.querySelectorAll('.panel').forEach(p => {
        p.style.display = "none";
    });

    // Mostrar la seleccionada
    document.getElementById(id).style.display = "block";

    // Quitar "active" a todos los botones
    document.querySelectorAll('.menu-btn').forEach(b => b.classList.remove("active"));

    // Activar el botón clicado
    boton.classList.add("active");

    if (id === "panelCalendario") {
    setTimeout(cargarCalendario, 100);
}

}
function estadoTexto(estado) {
    switch (estado) {
        case "REGISTRADA": return "Registrada";
        case "CANCELADA": return "Cancelada";
        case "FINALIZADA": return "Finalizada";
        default: return estado;
    }
}


function abrirModalServicio() {
    document.getElementById("formServicio").reset();
    document.getElementById("idServicio").value = "";
    document.getElementById("tituloModal").innerText = "Nuevo Servicio";

    document.getElementById("modalServicio").style.display = "flex";
}

function cerrarModalServicio() {
    document.getElementById("modalServicio").style.display = "none";
}

async function editarServicio(id) {
    const resp = await fetch("/api/servicios");
    const servicios = await resp.json();
    const s = servicios.find(x => x.id === id);

    document.getElementById("idServicio").value = s.id;
    document.getElementById("nombreServicio").value = s.nombre;
    document.getElementById("duracionServicio").value = s.duracion;
    document.getElementById("precioServicio").value = s.precio;

    document.getElementById("tituloModal").innerText = "Editar Servicio";

    document.getElementById("modalServicio").style.display = "flex";
}
async function archivarServicio(id) {
    if (!confirm("¿Archivar este servicio?")) return;

    await fetch(`/api/servicios/${id}`, { method: "DELETE" });

    cargarServicios();
}


// -------------------------------------------
// CARGAR DATOS DEL DASHBOARD
// -------------------------------------------
async function cargarTotales() {
    try {
        const resp = await fetch("/api/dashboard/totales");
        const data = await resp.json();

        document.getElementById("totalCitasMes").innerText = data.citasMes;
        document.getElementById("totalServicios").innerText = data.serviciosActivos;
        document.getElementById("totalClientes").innerText = data.clientesRegistrados;

    } catch (e) {
        console.error("Error cargando totales:", e);
    }
}

// Ejecutar al cargar el dashboard
cargarTotales();



// -------------------------------------------
// CARGAR CITAS
// -------------------------------------------
async function cargarCitas() {
    const resp = await fetch("/api/citas");
    const citas = await resp.json();

    const body = document.querySelector("#tablaCitas tbody");
    body.innerHTML = "";

    citas.forEach(c => {
        body.innerHTML += `
            <tr>
                <td>${c.cliente.nombre}</td>
                <td>${c.servicio.nombre}</td>
                <td>${c.fecha}</td>
                <td>${c.horaInicio} - ${c.horaFin}</td>
                <td>${estadoTexto(c.estado)}</td>

            </tr>
        `;
    });
}


// -------------------------------------------
// CARGAR CLIENTES
// -------------------------------------------
async function cargarClientes() {
    const resp = await fetch("/api/usuarios/clientes");
    const clientes = await resp.json();

    const body = document.querySelector("#tablaClientes tbody");
    body.innerHTML = "";

    clientes.forEach(c => {
        body.innerHTML += `
            <tr>
                <td>${c.nombre}</td>
                <td>${c.telefono}</td>
                <td>${c.email ?? '-'}</td>
            </tr>
        `;
    });
}


// -------------------------------------------
// CARGAR SERVICIOS
// -------------------------------------------
async function cargarServicios() {
    const resp = await fetch("/api/servicios");
    const servicios = await resp.json();

    const body = document.querySelector("#tablaServicios tbody");
    body.innerHTML = "";

    servicios.forEach(s => {
        body.innerHTML += `
<tr>
    <td>${s.nombre}</td>
    <td>${s.duracion} min</td>
    <td>$${s.precio}</td>
    <td>
        <button onclick="editarServicio(${s.id})">Editar</button>
        <button onclick="archivarServicio(${s.id})">Archivar</button>
    </td>
</tr>`;

    });
}
document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("formServicio");
    if (!form) return; 

    form.addEventListener("submit", async e => {
        e.preventDefault();

        const id = document.getElementById("idServicio").value;

        const datos = {
            nombre: document.getElementById("nombreServicio").value,
            duracion: Number(document.getElementById("duracionServicio").value),
precio: Number(document.getElementById("precioServicio").value)
        };

        const url = id ? `/api/servicios/${id}` : "/api/servicios";
        const metodo = id ? "PUT" : "POST";

        await fetch(url, {
            method: metodo,
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(datos)
        });

        cerrarModalServicio();
        cargarServicios();
    });
});


async function cargarCalendario() {

    const resp = await fetch("/api/citas");
    const citas = await resp.json();

    const eventos = citas.map(c => ({
    title: c.servicio.nombre,
    start: `${c.fecha}T${c.horaInicio}`,
    end: `${c.fecha}T${c.horaFin}`,
    color: "#6B0606"
}));


    const calendarEl = document.getElementById('calendario');

    const calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        locale: 'es',
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
        events: eventos
    });

    calendar.render();
}




// Al cargar la página, cargamos datos
cargarCitas();
cargarClientes();
cargarServicios();

mostrarSeccion("panelDashboard", document.querySelector(".menu-btn"));
