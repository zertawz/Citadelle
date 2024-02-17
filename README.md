# Citadelle
## to execute using the command line on a Unix-like shell:
There is launcher, so we will use it:

1. Go to the directory where this ReadMe is:
2. compile the code:
```bash
javac src/launchers/<launcherName>.java -d bin
```
Because JAVA will automatically search for dependencies and compile them, you can also use:
```bash
javac $(find . -name *.java) -d bin
```
3. Execute:
```bash
java -cp bin launchers.<laucherName>
```
