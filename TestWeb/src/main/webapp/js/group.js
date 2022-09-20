const arr=[]

for (i = 1; i<5; i++) {
	console.log($('#'+(i*10)))
	console.log($('#10'))
	
	$.ajax({
    url : "get_child?currLevel="+i+"&currLimit=-1",
    type : "POST",
    async: false,
    success : function(data) {
        let userData = null;
            try {
    		userData = JSON.parse(data); 
			} catch (e) {
			    
			    userData = data;
			}
		
		console.log($('#'+(i*10)))
		console.log(userData)
		
		if (i<4){
			for (j = 0; j<userData.allList.length; j++) {
				
				if(!(arr.includes(userData.allList[j]['departmentName']+userData.allList[j]['level']))){
					arr.push(userData.allList[j]['departmentName']+userData.allList[j]['level'])
					console.log(arr);
					
					$('#'+(i*10)).append('<div class ="container" id ='+userData.allList[j]['departmentName']+userData.allList[j]['level']+
					'><br><dept-el id = '+userData.allList[j]['id']+ 
					' deptname='+userData.allList[j]['departmentName']+
					' name ='+userData.allList[j]['name']+
					' role="Lead by: "></dept-el><br></div>');					
					}
					
				else{
					$('#'+(userData.allList[j]['departmentName']+userData.allList[j]['level'])).append('<br><dept-el id = '+userData.allList[j]['id']+
					' deptname='+userData.allList[j]['departmentName']+
					' name ='+userData.allList[j]['name']+
					' role="Lead by: "></dept-el><br>');	
				}
				
				
				
	        
	    }
	    }
		else{
			for (j = 0; j<userData.allList.length; j++) {
				if(!(arr.includes(userData.allList[j]['departmentName']+userData.allList[j]['level']))){
					arr.push(userData.allList[j]['departmentName']+userData.allList[j]['level'])
					console.log(arr);
					
					$('#'+(i*10)).append('<div class ="container" id ='+userData.allList[j]['departmentName']+userData.allList[j]['level']+
					'><br><dept-el  id = '+userData.allList[j]['id']+
					' deptname='+userData.allList[j]['departmentName']+
					' name ='+userData.allList[j]['name']+
					' role="Member: "></dept-el><br></div>');					
					}
					
				else{
					$('#'+(userData.allList[j]['departmentName']+userData.allList[j]['level'])).append('<br><dept-el id = '+userData.allList[j]['id']+
					' deptname='+userData.allList[j]['departmentName']+
					' name ='+userData.allList[j]['name']+
					' role="Member: "></dept-el><br>');	
				}
				
		  	

	    }			
		}
		}
		
	    });
	    
}