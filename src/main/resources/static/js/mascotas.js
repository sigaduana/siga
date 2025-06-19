// js/mascotas.js
document.getElementById('mascotaForm').addEventListener('submit', async function(e) {
  e.preventDefault();
  const nombre = document.getElementById('nombre').value;
  const raza = document.getElementById('raza').value;

  const response = await fetch('http://localhost:3000/mascotas', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ nombre, raza })
  });

  if (response.ok) {
    alert('Mascota registrada');
  } else {
    alert('Error al registrar mascota');
  }
});