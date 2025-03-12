document.addEventListener('DOMContentLoaded', (event) => {
    const form = document.getElementById('miFormulario');

    form.addEventListener('submit', function(e) {
        e.preventDefault();

        const nombre = document.getElementById('nombre').value;

        fetch('scrphp.php', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: 'nombre=' + encodeURIComponent(nombre)
        })
        .then(response => response.text())
        .then(data => {
            document.getElementById('resultado').innerHTML = data;
        })
        .catch(error => console.error('Error:', error));
    });
});
