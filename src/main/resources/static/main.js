document.getElementById("formMascota").addEventListener("submit", function (e) {
  e.preventDefault();

  const formData = new FormData(this);
  const data = Object.fromEntries(formData.entries());

  fetch("/api/mascotas", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data)
  })
    .then(res => {
      if (res.ok) {
        document.getElementById("mensajeMascota").innerText = "Formulario enviado con éxito.";
      } else {
        document.getElementById("mensajeMascota").innerText = "Error al enviar el formulario.";
      }
    });
});
