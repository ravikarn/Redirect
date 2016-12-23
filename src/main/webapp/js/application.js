var myApp=angular.module('myApp', []).config(function($routeProvider,$httpProvider) {
	$routeProvider.
	when('/read', {
		templateUrl : 'pages/read.html',
		controller : 'readCtrl'
	}).
	when('/update', {
		templateUrl : 'pages/update.html',
		controller : 'updateCtrl'
	}).
	when('/delete', {
		templateUrl : 'pages/delete.html',
		controller : 'deleteCtrl'		
	}).
	when('/404', {
		templateUrl : 'pages/notfound.html',
		controller : 'notfoundCtrl'		
	}).
	when('/create', {
		templateUrl : 'pages/create.html',
		controller : 'homeCtrl'		
	}).
	when('/upload', {
		templateUrl : 'pages/upload.html',
		controller : 'uploadCtrl'		
	}).
	otherwise({
		redirectTo : '/404'
	});
} );


