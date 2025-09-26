document.addEventListener('DOMContentLoaded', () => {

    // 1. Funcionalidad: Validación Básica del Formulario
    const form = document.getElementById('registroForm');

    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Detener el envío del formulario para la validación

        const nombre = document.getElementById('nombre').value.trim();
        const correo = document.getElementById('correo').value.trim();

        let isValid = true;
        let message = '';

        // Validación 1: Correo no vacío
        if (correo === '') {
            message += '❌ El correo electrónico no puede estar vacío.\n';
            isValid = false;
        }

        // Validación 2: Nombre mayor a 3 caracteres
        if (nombre.length <= 3) {
            message += '❌ El nombre debe tener más de 3 caracteres.\n';
            isValid = false;
        }

        // Mostrar resultado
        if (isValid) {
            // Si es válido, enviamos la alerta personalizada
            alert(`🎉 ¡Registro Exitoso, ${nombre}! \n\nRecibirás las novedades de Café Cósmico en ${correo}.`);
            form.reset(); // Limpiar el formulario
        } else {
            // Si NO es válido, mostramos los errores
            alert(`⚠️ Error de Validación:\n\n${message}`);
        }
    });


    // 2. Funcionalidad: Botón con Evento Dinámico
    const colorBtn = document.getElementById('cambiarColorBtn');
    const body = document.body;
    const infoOculta = document.getElementById('infoOculta');

    // a) Mostrar/Ocultar Contenido
    colorBtn.addEventListener('click', () => {
        // Toggle (Mostrar/Ocultar) el contenido extra
        if (infoOculta.classList.contains('hidden')) {
            infoOculta.classList.remove('hidden');
        } else {
            infoOculta.classList.add('hidden');
        }

        // b) Cambiar Color (Alternar un "Modo Estelar" - ejemplo de cambio de color/estilo)
        body.classList.toggle('modo-estelar');

        // c) Alerta Personalizada (Otro ejemplo de evento dinámico)
        if (body.classList.contains('modo-estelar')) {
             alert('🌌 ¡Activaste el Modo Estelar! Echa un vistazo a la información oculta.');
             colorBtn.textContent = 'Modo Normal ☕';
        } else {
            alert('🌙 Volviste al modo normal.');
            colorBtn.textContent = 'Modo Estelar ✨';
        }
    });

    // Añadir un poco de estilo al 'modo-estelar' en el body (aunque el CSS lo podría hacer,
    // es un ejemplo de cómo JS puede modificar estilos)
    const styleSheet = document.createElement("style");
    styleSheet.type = "text/css";
    styleSheet.innerText = `
        .modo-estelar {
            background-color: #2e1a2e; /* Color oscuro diferente */
            color: #d8c2ff; /* Texto más claro */
        }
        .modo-estelar header {
            background-color: #3f273f;
        }
        .modo-estelar .hero h1 {
            color: #ffc2d8;
        }
    `;
    document.head.appendChild(styleSheet);
});
