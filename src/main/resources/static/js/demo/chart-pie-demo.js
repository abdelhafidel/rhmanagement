// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

//doughnut
var ctxD = document.getElementById("doughnutChart").getContext('2d');
var myLineChart = new Chart(ctxD, {
type: 'doughnut',
data: {
labels: ["Red", "Green", "Yellow", "Grey", "Dark Grey"],
datasets: [{
data: [300, 50, 100, 40, 120],
backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"],
hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"]
}]
},
options: {
responsive: true
}
});

var ourRequest2 = new XMLHttpRequest();

ourRequest2.open('GET','http://localhost:8080/chartpie')

ourRequest2.onload = function() {
	var userN = JSON.parse(ourRequest2.responseText).userN;
	var userR = JSON.parse(ourRequest2.responseText).userR;
	console.log(userN,userR);
	piechart(userN,userR);
};
ourRequest2.send();

// Pie Chart Example
function piechart(userN,userR) {

var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: userR,
    datasets: [{
      data: userN,
      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc','#085996','#b80f14','#e0c707','#291380','#ff9100'],
      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
      hoverBorderColor: "rgba(234, 236, 244, 1)",
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: false
    },
    cutoutPercentage: 80,
  },
});

}



var ourRequest3 = new XMLHttpRequest();

ourRequest3.open('GET','http://localhost:8080/chart3')

ourRequest3.onload = function() {
	var userN = JSON.parse(ourRequest3.responseText).userHT;
	console.log(userN);
	chart3(userN);
};
ourRequest3.send();

// Pie Chart Example
function chart3(userN) {

var ctx = document.getElementById("Chart3");
var myPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: ['HEURES TRAVAILLER','HEURES REST'],
    datasets: [{
      data: userN,
      backgroundColor: ['#223ec9', '#28de92', '#36b9cc','#085996','#b80f14','#e0c707','#291380','#ff9100'],
      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
      hoverBorderColor: "rgba(234, 236, 244, 1)",
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: false
    },
    cutoutPercentage: 80,
  },
});

}





//radar
var ctxR = document.getElementById("radarChart").getContext('2d');
var myRadarChart = new Chart(ctxR, {
type: 'radar',
data: {
labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
datasets: [{
label: "My First dataset",
data: [65, 59, 90, 81, 56, 55, 40],
backgroundColor: [
'rgba(105, 0, 132, .2)',
],
borderColor: [
'rgba(200, 99, 132, .7)',
],
borderWidth: 2
},
{
label: "My Second dataset",
data: [28, 48, 40, 19, 96, 27, 100],
backgroundColor: [
'rgba(0, 250, 220, .2)',
],
borderColor: [
'rgba(0, 213, 132, .7)',
],
borderWidth: 2
}
]
},
options: {
responsive: true
}
});