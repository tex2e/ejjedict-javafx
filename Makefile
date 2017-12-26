
all: build run

build:
	jar cvmf manifest.txt dict.jar -C classes . fxml

run:
	java -jar dict.jar
