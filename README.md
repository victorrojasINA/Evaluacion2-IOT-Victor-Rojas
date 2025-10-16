Evaluación Sumativa N°2 - Victor Rojas - Aplicaciones Móviles para IoT (TI3042)

Qué se hizo en este proyecto?

Se desarrolló una aplicación para Android que simula un sistema de login, cumpliendo con los requisitos de la evaluación

Se crearon tres pantallas principales que se conectan entre sí: una para **iniciar sesión**, otra para **registrarse** y una última para **recuperar la contraseña**

Siguiendo las instrucciones del profesor, se agregó una pantalla de carga al principio (Splash Screen) con un logo personalizado. Este mismo diseño se utilizó también como el **ícono de la aplicación**, tal como se indicaba

Para cumplir con el requisito de avisar al usuario, cada acción importante (como presionar el botón de registrar) muestra una ventana de alerta (`AlertDialog`)

Además, para asegurar una navegación buena y fluida, después de registrarse o recuperar la clave, la app vuelve sola a la pantalla de login

Finalmente, para obtener el puntaje extra (cosa que dijo el profesor en clase), se implementó la **funcionalidad opcional** de la rúbrica que consiste en un botón para revisar si el Bluetooth del teléfono está prendido o apagado

Que pasa con la seguridad?

Para la seguridad, y en base a los lineamientos de la evaluación que mencionan el estándar ISO, la app no pide permisos que no necesite (cosas que no son necesarias o cosas sospechosas)

El único que solicita es el del Bluetooth (para la parte del bonus), y se le pregunta directamente al usuario si quiere darlo

Tampoco hay ninguna contraseña o correo escrito directamente en el código, cumpliendo con la buena práctica de no usar datos sensibles
