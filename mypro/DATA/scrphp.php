<?php
if (isset($_POST['submit']) && isset($_FILES['file'])) {
    $header_expected = ['nombre', 'edad', 'ciudad'];
    $allowedTypes = ['application/CSV'];
    $fileType = $_FILES['file']['type'];
    $filename = $_FILES['file']['tmp_name'];
    $indices = [];
    
    if ($_FILES['file']['size'] > 0) {
        $file = fopen($filename, "r");
        $header = fgetcsv($file, 10000, ",");
        $columnas = [];
        
        if ($header !== FALSE) {
            foreach ($header as $column) {
                array_push($columnas, $column);
            }
        }
        
        foreach ($header_expected as $column) {
            $i = array_search($column, $columnas);
            array_push($indices, $i);
        }
        
        // Especificar la ruta donde se guardará el nuevo archivo CSV
        $directory = "/SL Local";
        $baseFileName = "NUEVO.csv";
        $newFileName = "$directory/$baseFileName"; // Ruta relativa
        
        // Crear la carpeta si no existe
        if (!is_dir($directory)) {
            if (!mkdir($directory, 0777, true)) {
                die("Error al crear la carpeta $directory");
            }
        }
        
        // Verificar si el archivo ya existe y cambiar el nombre si es necesario
        $counter = 1;
        while (file_exists($newFileName)) {
            $newFileName = "$directory/NUEVO_$counter.csv";
            $counter++;
        }
        
        // Crear y abrir el nuevo archivo CSV en modo de escritura
        $newFile = fopen($newFileName, "w");
        if ($newFile === FALSE) {
            die("Error al abrir el archivo $newFileName para escritura");
        }
        
        // Escribir el encabezado en el nuevo archivo CSV
        if (fputcsv($newFile, $header_expected) === FALSE) {
            die("Error al escribir el encabezado en el archivo $newFileName");
        }
        
        while (($getData = fgetcsv($file, 10000, ",")) !== FALSE) {
            $newRow = [];
            for ($i = 0; $i < count($indices); $i++) {
                $newRow[] = $getData[$indices[$i]];
            }
            // Escribir la nueva fila en el nuevo archivo CSV
            if (fputcsv($newFile, $newRow) === FALSE) {
                die("Error al escribir una fila en el archivo $newFileName");
            }
        }
        
        fclose($file);
        fclose($newFile);
        
        echo "Archivo CSV creado y guardado con éxito: <a href='$newFileName'>$newFileName</a>";
    } else {
        echo "tipo de archivo no compatible";
    }
} else {
    echo "No se ha cargado ningún archivo.";
}
?>