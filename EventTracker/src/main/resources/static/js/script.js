console.log("script js loaded");

window.addEventListener('load', function(e) {
	console.log('DOM created');
	init();
})

function init() {
	loadExercises();
	loadExerciseTypes();

	newExerciseForm.addExercise.addEventListener("click", function(e) {
		e.preventDefault();
		let exercise = {
			notes: newExerciseForm.notes.value,
			duration: newExerciseForm.duration.value,
			averageHeartRate: newExerciseForm.averageHeartRate.value,
			caloriesBurned: newExerciseForm.caloriesBurned.value,
			exerciseDate: newExerciseForm.exerciseDate.value
		}
		addNewExercise(exercise);
	})
	
	updateExerciseForm.updateExercise.addEventListener("click", function(e) {
		e.preventDefault();
		let exercise = {
			id: updateExerciseForm.id.value,
			notes: updateExerciseForm.notes.value,
			duration: updateExerciseForm.duration.value,
			averageHeartRate: updateExerciseForm.averageHeartRate.value,
			caloriesBurned: updateExerciseForm.caloriesBurned.value,
			exerciseDate: updateExerciseForm.exerciseDate.value
		}
		updateExercise(exercise);
	})
}

function loadExercises() {
	let url = 'api/exercises';
	let xhr = new XMLHttpRequest();
	xhr.open('GET', url, true);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let exercises = JSON.parse(xhr.responseText);
				displayExercises(exercises);
			}
		}
	}
	console.log('Sending')
	xhr.send();
}

function displayExercises(exercises) {

	let tableDiv = document.getElementById('tableDiv');
	tableDiv.textContent = "";

	let table = document.createElement('table');
	tableDiv.appendChild(table);

	let thead = document.createElement('thead');
	table.appendChild(thead);

	let tr = document.createElement('tr');
	thead.appendChild(tr);

	let th = document.createElement('th');
	th.textContent = "Date";
	tr.appendChild(th);

	th = document.createElement('th');
	th.textContent = 'Name';
	tr.appendChild(th);

	th = document.createElement('th');
	th.textContent = 'Duration';
	tr.appendChild(th);

	th = document.createElement('th');
	th.textContent = 'Average Heart Rate';
	tr.appendChild(th);

	th = document.createElement('th');
	th.textContent = 'Calories Burned';
	tr.appendChild(th);

	th = document.createElement('th');
	th.textContent = '';
	tr.appendChild(th);
	
	th = document.createElement('th');
	th.textContent = '';
	tr.appendChild(th);
	

	let tbody = document.createElement('tbody');
	table.appendChild(tbody);

	for (let exercise of exercises) {
		let tr = document.createElement('tr');
		tbody.appendChild(tr);

		let td = document.createElement('td');
		td.textContent = exercise.exerciseDate;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = exercise.exerciseType.name;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = exercise.duration + "hrs";
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = exercise.averageHeartRate + "bpm";
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = exercise.caloriesBurned + 'kcal';
		tr.appendChild(td);

		td = document.createElement('td');
		let addButton = document.createElement('button');
		addButton.textContent = "Update";
		addButton.addEventListener("click", function(e) {
			goToUpdateForm(exercise.id);
		})
		td.appendChild(addButton);
		tr.appendChild(td);
		
		td = document.createElement('td');
		let deleteButton = document.createElement('button');
		deleteButton.textContent = "Delete";
		deleteButton.addEventListener("click", function(e) {
			deleteExercise(exercise.id);
		})
		td.appendChild(deleteButton);
		tr.appendChild(td);

	};
}

function loadExerciseTypes() {
	let url = 'api/exerciseTypes';
	let xhr = new XMLHttpRequest();
	xhr.open('GET', url, true);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let exercises = JSON.parse(xhr.responseText);
				displayExerciseTypes(exercises);
			}
		}
	}
	xhr.send();
}

function displayExerciseTypes(exerciseTypes) {
	let dropdown1 = document.getElementById("createTypes");
	dropdown1.textContent = '';

	let dropdown2 = document.getElementById("updateTypes");
	dropdown2.textContent = '';

	for (let exerciseType of exerciseTypes) {
		let opt1 = document.createElement('option');
		opt1.textContent = exerciseType.name;
		opt1.value = exerciseType.id;

		let opt2 = document.createElement('option');
		opt2.textContent = exerciseType.name;
		opt2.value = exerciseType.id;

		dropdown1.appendChild(opt1);
		dropdown2.appendChild(opt2);
	}
}

function addNewExercise(exercise) {
	let url = "api/exercises";
	let xhr = new XMLHttpRequest();
	xhr.open('POST', url)

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 201) {
				let createdExercise = JSON.parse(xhr.responseText);
				displayExercises(createdExercise);
			} else {
				xhr.statusText;
			}
		}
	}
	xhr.setRequestHeader("content-type", "application/json");
	let exerciseJSON = JSON.stringify(exercise);
	xhr.send(exerciseJSON);
}

function goToUpdateForm(exerciseId) {
	let url = 'api/exercises/' + exerciseId;
	let xhr = new XMLHttpRequest();
	xhr.open('GET', url, true);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let exercise = JSON.parse(xhr.responseText);
				displayUpdateForm(exercise);
			}
		}
	}
	xhr.send();
}

function displayUpdateForm(exercise) {
	let form = document.updateExerciseForm;
	form.id.value = exercise.id;
	form.duration.value = exercise.duration;
	form.notes.value = exercise.notes;
	form.averageHeartRate.value = exercise.averageHeartRate;
	form.caloriesBurned.value = exercise.caloriesBurned;
	form.exerciseDate.value = exercise.exerciseDate;
	showUpdateForm();
}

function updateExercise(exercise) {
	let url = "api/exercises/" + exercise.id;
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', url)

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				let updatedExercise = JSON.parse(xhr.responseText);
				loadExercises();
				showAddForm();
			} else {
				xhr.statusText;
			}
		}
	}
	xhr.setRequestHeader("content-type", "application/json");
	let exerciseJSON = JSON.stringify(exercise);
	xhr.send(exerciseJSON);
}

function showUpdateForm(){
	let updateDiv = document.getElementById("updateExercise");
	let addDiv = document.getElementById("addExercise");
	
	updateDiv.style.display = "block";
	addDiv.style.display = "none";
}
function showAddForm(){
	let updateDiv = document.getElementById("updateExercise");
	let addDiv = document.getElementById("addExercise");
	
	updateDiv.style.display = "none";
	addDiv.style.display = "block";
}

function deleteExercise(exerciseId) {
	let url = "api/exercises/" + exerciseId;
	let xhr = new XMLHttpRequest();
	xhr.open('DELETE', url);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 204) {
				loadExercises();     
				showAddForm();       
			} else {
				console.error('Failed to delete exercise:', xhr.status, xhr.statusText);
			}
		}
	};

	xhr.send(); 
}


