var bugTrackerApp = angular.module('bugTrackerApp', []);
        bugTrackerApp.controller('bugsController', function($scope){
            $scope.bugs = [
                { name : 'User authentication is wrong', isClosed : true},
                { name : 'Server communication failure', isClosed : false},
                { name : 'Data doesnt display', isClosed : false},
                { name : 'statistics are not accurate', isClosed : true}
            ];
            $scope.newBugName = ''
            $scope.addNew = function(){
                var newBug = {
                    name : $scope.newBugName,
                    isClosed : false
                };
                $scope.bugs.push(newBug);
                $scope.newBug = '';
            };
            $scope.toggleBug = function(bug){
                bug.isClosed = !bug.isClosed;
            };
            $scope.removeClosed = function(){
                for(var i=$scope.bugs.length-1; i>=0; i--)
                    if ($scope.bugs[i].isClosed)
                        $scope.bugs.splice(i,1);
            };
            $scope.getClosedCount = function(){
                var result = 0;
                for(var i = 0;i<$scope.bugs.length; i++)
                    if ($scope.bugs[i].isClosed) ++result;
                return result;
            }
        });