# Variáveis
SRC_DIR = src
BIN_DIR = bin
JAVAC = javac
JAVA = java

# Pastas dentro de src
APP_DIR = application
SERVICES_DIR = services

# Lista de arquivos .java
SOURCES = $(wildcard $(SRC_DIR)/$(APP_DIR)/*.java) $(wildcard $(SRC_DIR)/$(SERVICES_DIR)/*.java)

# Regra padrão
all: compile

# Compila os arquivos .java
compile:
	@if [ -z "$(SOURCES)" ]; then \
		echo "Nenhum arquivo .java encontrado em $(SRC_DIR)."; \
		exit 1; \
	fi
	@mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $(SOURCES)

# Executa o programa principal (substitua 'MainClass' pelo nome da sua classe principal)
run: compile
	$(JAVA) -cp $(BIN_DIR) application.Program

# Limpa os arquivos .class gerados
clean:
	rm -rf $(BIN_DIR)/*.class