CREATE DATABASE Hospital

CREATE TABLE TipoUsuario(
	idTipoUsuario int IDENTITY(1,1) NOT NULL,
	tipoUsuario varchar(20) NOT NULL
	CONSTRAINT PK_TipoUsuario PRIMARY KEY CLUSTERED (idTipoUsuario)
)

CREATE TABLE Turno(
	idTurno int IDENTITY(1,1) NOT NULL,
	turno VARCHAR(10) NOT NULL
	CONSTRAINT PK_Turno PRIMARY KEY CLUSTERED (idTurno)
)

CREATE TABLE Especialidad(
	idEspecialidad INT IDENTITY(1,1) NOT NULL,
	especialidad varchar(50) NOT NULL,
	CONSTRAINT PK_Especialidad PRIMARY KEY CLUSTERED (idEspecialidad)
)

CREATE TABLE Medicamento(
	idMedicamento int IDENTITY(1,1) NOT NULL,
	medicamento VARCHAR(50) NOT NULL,
	precio MONEY NOT NULL,
	CONSTRAINT PK_Medicamento PRIMARY KEY CLUSTERED (idMedicamento)
)

CREATE TABLE Usuario(
	email VARCHAR(50) NOT NULL,
	pass VARCHAR(50) NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	paterno VARCHAR(50) NOT NULL,
	materno VARCHAR(50) NOT NULL,
	telefono VARCHAR(10) NOT NULL,
	edad int NOT NULL,
	sexo bit NOT NULL,
	idTipoUsuario int NOT NULL,
	CONSTRAINT PK_Usuario PRIMARY KEY CLUSTERED (email),
	CONSTRAINT FK_Usuario_TipoUsuario FOREIGN KEY (idTipoUsuario) REFERENCES TipoUsuario (idTipoUsuario) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FK_Usuario_Sexo FOREIGN KEY (sexo) REFERENCES Sexo (idSexo) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE Sexo(
	idSexo int identity(1,1) not null,
	sexo varchar(10) not null,
	constraint PK_Sexo primary key clustered (idSexo)
)

CREATE TABLE Recepcionista(
	idRecep int IDENTITY(1,1) NOT NULL,
	email VARCHAR(50) NOT NULL,
	sueldo money NOT NULL,
	idTurno int NOT NULL,
	CONSTRAINT PK_Recepcionista PRIMARY KEY CLUSTERED (idRecep),
	CONSTRAINT FK_Recepcionista_Usuario FOREIGN KEY (email) REFERENCES Usuario (email) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FK_Recepcionista_Turno FOREIGN KEY (idTurno) REFERENCES Turno (idTurno) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE Medico(
	idMed int IDENTITY(1,1) NOT NULL,
	cedula VARCHAR(10) NOT NULL,
	sueldo money NOT NULL,
	email VARCHAR(50) NULL,
	idTurno int NOT NULL,
	idEspecialidad int NOT NULL,
	CONSTRAINT PK_Medico PRIMARY KEY CLUSTERED (idMed),
	CONSTRAINT FK_Medico_Usuario FOREIGN KEY (email) REFERENCES Usuario (email) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT FK_Medico_Especialidad FOREIGN KEY (idEspecialidad) REFERENCES Especialidad (idEspecialidad) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FK_Medico_Turno FOREIGN KEY (idTurno) REFERENCES Turno (idTurno) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE Alergias(
	idAlergia int IDENTITY(1,1) NOT NULL,
	alergia VARCHAR(50) NOT NULL,
	CONSTRAINT PK_Alergias PRIMARY KEY CLUSTERED (idAlergia)
)

CREATE TABLE EnfermedadesCronicas(
	idEnfermedad int IDENTITY(1,1) NOT NULL,
	enfermedad VARCHAR(50) NOT NULL,
	CONSTRAINT PK_EnfermedadesCronicas PRIMARY KEY CLUSTERED (idEnfermedad)
)

CREATE TABLE Paciente(
	idPac int IDENTITY(1,1) NOT NULL,
	seguroMedico VARCHAR(50) NOT NULL,
	tipoSangre VARCHAR(5) NOT NULL,
	email VARCHAR(50) NULL,
	CONSTRAINT PK_Paciente PRIMARY KEY CLUSTERED (idPac),
	CONSTRAINT FK_Paciente_Usuario FOREIGN KEY (email) REFERENCES Usuario (email) ON DELETE SET NULL ON UPDATE CASCADE
)

CREATE TABLE PacienteAlergias(
	idPac int NOT NULL,
	idAlergia int NOT NULL,
	CONSTRAINT PK_PacienteAlergias PRIMARY KEY CLUSTERED (idPac, idAlergia),
	CONSTRAINT FK_PacienteAlergias_Paciente FOREIGN KEY (idPac) REFERENCES Paciente (idPac) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FK_PacienteAlergias_Alergias FOREIGN KEY (idAlergia) REFERENCES Alergias (idAlergia) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE PacienteEnfermedades(
	idPac int NOT NULL,
	idEnfermedad int NOT NULL,
	CONSTRAINT PK_PacienteEnfermedades PRIMARY KEY CLUSTERED (idPac, idEnfermedad),
	CONSTRAINT FK_PacienteEnfermedades_Paciente FOREIGN KEY (idPac) REFERENCES Paciente (idPac) ON UPDATE CASCADE,
	CONSTRAINT FK_PacienteEnfermedades_EnfermedadesCronicas FOREIGN KEY (idEnfermedad) REFERENCES EnfermedadesCronicas (idEnfermedad) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE Expediente(
	idExpediente int IDENTITY(1,1) NOT NULL,
	idPac int NULL,
	CONSTRAINT PK_Expediente PRIMARY KEY CLUSTERED (idExpediente),
	CONSTRAINT FK_Expediente_Paciente FOREIGN KEY (idPac) REFERENCES Paciente (idPac) ON DELETE NO ACTION ON UPDATE CASCADE
)

CREATE TABLE Cita(
	idCita int IDENTITY(1,1) NOT NULL,
	fecha DATETIME NOT NULL,
	estadoCita int NOT NULL,
	precio money NOT NULL,
	horaCita time NOT NULL,
	idMed int NOT NULL,
	idPac int NOT NULL,
	idRec int NOT NULL,
	consultorio int,
	CONSTRAINT PK_Cita PRIMARY KEY CLUSTERED (idCita),
	CONSTRAINT FK_Cita_Paciente FOREIGN KEY (idPac) REFERENCES Paciente (idPac) ON DELETE NO ACTION ON UPDATE CASCADE,
    CONSTRAINT FK_Cita_Medico FOREIGN KEY (idMed) REFERENCES Medico (idMed) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT FK_Cita_Recepcionista FOREIGN KEY (idRec) REFERENCES Recepcionista (idRecep) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT FK_Cita_EstadosCita FOREIGN KEY (estadoCita) REFERENCES EstadosCita (idestadocita) ON DELETE CASCADE ON UPDATE CASCADE
)
	
CREATE TABLE EstadosCita(
	idestadocita INT IDENTITY(1,1) NOT NULL,
	descripcion VARCHAR(30) NOT NULL,
	CONSTRAINT PK_EstadosCita PRIMARY KEY CLUSTERED (idestadocita),
)

CREATE TABLE Receta(
	idReceta int IDENTITY(1,1) NOT NULL,
	prescripcion VARCHAR(200) NOT NULL,
	idCita int NOT NULL,
	CONSTRAINT PK_Receta PRIMARY KEY CLUSTERED (idReceta),
	CONSTRAINT FK_Receta_Cita FOREIGN KEY (idCita) REFERENCES Cita (idCita) ON DELETE NO ACTION ON UPDATE CASCADE
)

CREATE TABLE RecetaMedicamento(
	idReceta int NOT NULL,
	idMedicamento int NOT NULL,
	CONSTRAINT PK_RecetaMedicamento PRIMARY KEY CLUSTERED (idReceta, idMedicamento),
	CONSTRAINT FK_RecetaMedicamento_Receta FOREIGN KEY (idReceta) REFERENCES Receta (idReceta) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FK_RecetaMedicamento_Medicamento FOREIGN KEY (idMedicamento) REFERENCES Medicamento (idMedicamento) ON DELETE CASCADE ON UPDATE CASCADE
)

--							Funciones

-- Funci�n que recibe la cedula de un doctor y devuelve todas sus citas confirmadas
create function citasConfirmadas(@cedula varchar(50))
returns @tbCitasConfirmadas table(
	idCita int,
	fecha datetime,
	hora time,
	idPac int,
	nombrePaciente varchar(60)
)
as
begin
	insert into @tbCitasConfirmadas
	select c.idCita, c.fecha, c.horaCita, p.idPac, (u.nombre+' '+u.paterno+' '+u.materno) as 'Nombre del Paciente'
	from Medico m inner join Cita c on m.idMed=c.idMed inner join Paciente p on p.idPac=c.idPac inner join Usuario u on p.email=u.email
	where m.cedula=@cedula
	return
end

select * from dbo.citasConfirmadas ('HSDI-12345')

-- Funci�n que reciba un turno y devuelve la cantidad de medicos trabajando en ese turno
create function medicosTurno (@turno varchar(10))
returns int
as
	begin declare @totalMedicos int
	select @totalMedicos = count(m.idMed)
	from Medico m inner join Turno t on m.idTurno=t.idTurno
	where t.turno = @turno
	return @totalMedicos
end

select dbo.medicosTurno ('Vespertino') as 'Numero de doctores'

-- Funci�n que recibe una edad y devuelve todos los usuarios con la misma edad o menor
create function comparacionEdad (@edad int)
returns @tbUsuariosaEdad table(
	nombre varchar(50),
	edad int
)
as
begin
	insert into @tbUsuariosaEdad
	select (nombre+' '+paterno+' '+materno), edad
	from Usuario
	where edad<=@edad
	return
end

select * from dbo.comparacionEdad (40)

-- Funci�n que recibe el id de un Paciente y dos fechas y devuelve la cantidad de citas que tuvo entre las fechas dadas
create function numCitas (@idPac int, @inicio datetime, @final datetime)
returns int
as
	begin declare @numCitas int
	select @numCitas = count(c.idCita)
	from Paciente p inner join Cita c on p.idPac=c.idPac
	where (c.fecha between @inicio and @final) and c.estadoCita=1 and c.idPac=@idPac
	return @numCitas
end

select dbo.numCitas (3,'2024-01-10T00:00:00.000','2024-02-02T00:00:00.000') as 'Numero de citas'

--							Vistas

-- Vista de los empleados del hospital (Medicos y Recepcionistas)
create view Vista_empleados as
select (u.nombre+' '+u.paterno+' '+u.materno) as 'Nombre del Empleado', t.tipoUsuario as 'Tipo de Empleado'
from Usuario u join TipoUsuario t on u.idTipoUsuario=t.idTipoUsuario
where u.idTipoUsuario!=3

select * from Vista_empleados

-- Vista de cuantas veces se han comprado los medicamentos vendidos en el hospital
create view Vista_Medicamentos_Cuentas as
select m.medicamento as 'Medicamento', count(r.idMedicamento) as 'Veces vendido'
from Medicamento m JOIN RecetaMedicamento r on m.idMedicamento = r.idMedicamento
group by m.medicamento

select * from Vista_Medicamentos_Cuentas

-- Vista de cuantas veces se le ha recetado cierto medicamento a un paciente
create view Vista_Control_Medicamento_Paciente as
select u.nombre as 'Nombre', u.paterno as 'Apellido Paterno', u.materno as 'Apellido Materno', m.medicamento as 'Medicamento', count(re.idMedicamento) as 'Total de veces recetado'
from Usuario u join Paciente p on u.email=p.email join Cita c on p.idPac=c.idCita join Receta r on c.idCita=r.idCita 
join RecetaMedicamento re on r.idReceta=re.idReceta join Medicamento m on re.idMedicamento=m.idMedicamento
group by u.nombre, u.paterno, u.materno, m.medicamento

select * from Vista_Control_Medicamento_Paciente

-- Vista de una lista de los doctores y el numero de citas que han dado en total
create view Vista_Citas_Doctores as
select u.nombre as 'Nombre', u.paterno as 'Apellido Paterno', u.materno as 'Apellido Materno', count(c.idCita) as 'Numero de citas totales'
from Usuario u join Medico m on u.email=m.email join Cita c on m.idMed=c.idMed
where c.estadoCita=2
group by u.nombre, u.paterno, u.materno

select * from Vista_Citas_Doctores
