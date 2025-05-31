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
	});
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
		td.textContent = exercise.duration + " hrs";
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = exercise.averageHeartRate;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = exercise.caloriesBurned + 'kcal';
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
	console.log('Sending')
	xhr.send();
}

function displayExerciseTypes(exerciseTypes) {
	let dropdown = document.getElementById("myDropdown");
	dropdown.textContent = '';

	for (let exerciseType of exerciseTypes) {
		let opt = document.createElement('option');
		opt.textContent = exerciseType.name;
		opt.value = exerciseType.id;
		dropdown.appendChild(opt);
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

function updateExercise(exercise) {
	let url = "api/exercises";
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', url)

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

