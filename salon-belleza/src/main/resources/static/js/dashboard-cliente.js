const citas = [];

const form = document.getElementById("formCita");
const tabla = document.querySelector("#tablaCitas tbody");

form.addEventListener("submit", (e) => {
    e.preventDefault();

    const nombre = form.nombre.value.trim();
    const servicio = form.servicio.value;
    const fecha = form.fecha.value;
    const hora = form.hora.value;

    if (!nombre || !servicio || !fecha || !hora) {
        alert("Por favor complete todos los campos.");
        return;
    }

    citas.push({ servicio, fecha, hora });
    form.reset();
    mostrarCitas();
});

function mostrarCitas() {
    tabla.innerHTML = "";
    citas.forEach(cita => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${cita.servicio}</td>
            <td>${cita.fecha}</td>
            <td>${cita.hora}</td>
            <td>
    ${c.estado === "CANCELADA" 
        ? "<span style='color:red;'>Cancelada</span>"
        : `<button onclick="cancelarCita(${c.id})" class="btn-cancelar">Cancelar</button>`}
</td>
        `;
        tabla.appendChild(row);
    });
}

async function cancelarCita(id) {

    if (!confirm("¿Deseas cancelar esta cita?")) return;

    try {
        const resp = await fetch(`/api/citas/cancelar/${id}`, { method: "PUT" });

        if (!resp.ok) {
            const msg = await resp.text();
            alert(msg);
            return;
        }

        alert("Cita cancelada con éxito");
        cargarCitas();

    } catch (error) {
        alert("Error al cancelar la cita");
    }
}


