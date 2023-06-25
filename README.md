# Cryocool
![Version](https://img.shields.io/badge/MC_Version-1.20.1-blue)

Prevents (the majority of) disk reads and writes that a Minecraft client attempts. 

Note that this doesn't _fully_ prevent disk accesses! A malicious program could still write to anywhere it wants - it only prevents the game complaining or crashing when run in a hostile environment. I would suggest running the client in an OS-provided sandbox of some form (docker would also work).

### Notes
Fabric doesn't provide a way to overwrite the Log4J configuration for the client, as providing said config file is usually the job of the game's launcher - this means that unless you set the file permissions to force it not to, this mod on its own will not prevent the `logs` folder being created, and `latest.log`, `debug.log` and their compressed forms from being placed there. 

Additionally, Fabric Loom does not work properly in development environments if `run` is read-only and the `resources` directory within is non-existent, despite not actually writing files to this folder.