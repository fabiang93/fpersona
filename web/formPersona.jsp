
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Persona</title>
    </head>
    <body>
        <h1>INGRESE LA PERSONA A REGISTRAR</h1>
        <form action="registrarPersona.xml" method="post">
            <input type="text" name="txtId" placeholder="Número de Identificación" required="required"></br>
            <input type="text" name="txtNombre" placeholder="Nombres" required="required"></br>
            <input type="text" name="txtApellido" placeholder="Apellidos" required="required"></br>
            <input type="text" name="txtECvil" placeholder="Estado Civil" required="required"></br>
            <input type="text" name="txtOcupacion" placeholder="Ocupación" required="required"></br>
            <input type="submit" value="Guardar"></br>
            <a href='Menu.view'>Volver</a>
              
        </form>        
    </body>
</html>
