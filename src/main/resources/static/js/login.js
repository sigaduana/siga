// js/login.js
document.getElementById('loginForm').addEventListener('submit', async function(e) {
  e.preventDefault();
  const usuario = document.getElementById('usuario').value;
  const password = document.getElementById('password').value;

  const response = await fetch('http://localhost:3000/login', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ usuario, password })
  });

  if (response.ok) {
    // Guarda el token o sesión
    window.location.href = 'mascotas.html';
  } else {
    alert('Usuario o contraseña incorrectos');
  }
});