//---- Creating the data----------------------------------------------------------------------------
function homeCtrl($scope, $http, $location, $rootScope) {
	console.log("in addition controller");
	$scope.var1 = "This is my home page. CREATE";
	$scope.add = function(){

		console.log("in addition first");



		console.log($scope.emp);
		//console.log($scope.emp.id);
		console.log($scope.emp.fname);

		$http.post('rest/add',$scope.emp).success(function(){
			alert("Successfully added");
			$location.path("/read");
		}).error(function(){
			console.log("Error in  data from DB");
		});

	};
};


//-------------------------------------------------------------------------------------------------------
//----------Reading from Database------------------------------------------------------------------------
function readCtrl($scope, $http, $rootScope) {
	console.log("in read controller");
	$scope.var1 = "This is READ";
	$http.post('rest/get').success(function(data){
		console.log(data);
		$scope.modules = data;

	}).error(function(){
		console.log("Error in fetching data from DataBase");
	});
} ;
//-------------------------------------------------------------------------------------------------------
//-----Updating in DATABASE------------------------------------------------------------------------------
function updateCtrl($scope, $http, $location, $rootScope) {
	$scope.var1 = "This is UPDATE";

	console.log("update controller");
	var emp=[];
	$http.post('rest/get').success(function(data){
		$scope.modules = data;

	}).error(function(){
		console.log("Error in fetching data from DataBase");
	});



	$scope.updateRow=function()
	{
		console.log("update function");
		angular.forEach($scope.modules,function(s,key){

			if(s.k==true)
			{

				emp.push($scope.modules[key]);
				console.log(s);
				s.k=false;
			}

		});
		$http.post('rest/update',emp).success(function(){
			console.log(emp);
			alert("updated sucessfully");
			$location.path("/read");
		}).error(function(){
			console.log("Error in updating data ");
		});

	};

};


//-------------------------------------------------------------------------------------------------------
//---Deleting in database-------------------------------------------------------------------------------
function deleteCtrl($scope, $http, $location, $rootScope) {
	var index=[];
	$scope.var1 = "This is DELETE";
	console.log("in delete controller");
	$http.post('rest/get').success(function(data){
		$scope.modules = data;

	}).error(function(){
		console.log("Error in fetching data from DataBase");
	});

	$scope.delRow=function(){
		console.log("in delete function");
		angular.forEach($scope.modules,function(s,key){
			console.log("in delete !! "+key);
			if(s.k == true)
			{
				index.push($scope.modules[key].id);

			}
		});
		$http.post('rest/delete',index).success(function(){
			alert("Deleted successfully");
			$location.path("/read");
		}).error(function(){
			console.log("Error in Deleting data ");
		});	
	};	
};
//------------------------------------------------------------------------------------------------------
//------------------Not found Controller---------------------------------------------------
function notfoundCtrl($scope, $http, $location, $rootScope) {
	$scope.var1 = "Page not found";

} ;
function uploadCtrl($scope, $http, $location, $rootScope) {
	$scope.var1 = "This is upload Page";

	console.log("Upload function invoked");
	var formdata = new FormData();
	$scope.getTheFiles = function ($files) {

		angular.forEach($files, function (value, key) {
			
			console.log(key);
			console.log(value);
			formdata.append(key, value);
			//console.log("value is -"+value+"Key is -"+key);
		});

	};

	$scope.uploadFiles=function(){

		console.log(formdata);
		console.log(JSON.stringify(formdata));
		
		$http.post('rest/upload',formdata).success(function(){
			
			alert("uploaded sucessfully");
			$location.path("/upload");
		}).error(function(){
			console.log("Error in uploading data ");
		});

		console.log("Upload function invoked");
	};

} ;

