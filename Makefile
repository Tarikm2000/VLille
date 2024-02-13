all : play

classes:
	javac -sourcepath src -d classes src/*.java

play: classes
	java -classpath classes Main 

jar :  classes
	jar cvfe jeu.jar Main -C classes .

compileTests: classes
	javac -cp classes:junit-platform-console-standalone-1.10.1.jar -d classes  tests/*/*.java

runTests: compileTests classes
	java -jar junit-platform-console-standalone-1.10.1.jar -cp classes --scan-class-path
doc:
	javadoc -sourcepath src -d docs -subpackages bike visitor sharingStrategies state  observer

runJar: 
	java -jar jeu.jar

clean :
	rm -rf classes
	rm -rf docs
