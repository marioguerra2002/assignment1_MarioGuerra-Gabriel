# Makefile para compilar y ejecutar un programa Java

# Nombre del programa Java
PROGRAM_NAME = sum3_upperbound

# Archivos fuente Java
SOURCE_FILES = $(wildcard *.java)

# Directorio donde se guardarán los archivos compilados
BUILD_DIR = build

# Opciones del compilador Java
JAVAC_FLAGS = -d $(BUILD_DIR)

# Opción para eliminar los archivos compilados
CLEAN_OPTION = clean

# Regla principal para compilar el programa
all: $(PROGRAM_NAME)

$(PROGRAM_NAME): $(SOURCE_FILES)
	mkdir -p $(BUILD_DIR)
	javac $(JAVAC_FLAGS) $^

# Regla para ejecutar el programa
run:
	java -cp $(BUILD_DIR) $(PROGRAM_NAME)

# Regla para limpiar los archivos compilados
clean:
	rm -rf $(BUILD_DIR)

.PHONY: all run $(CLEAN_OPTION)