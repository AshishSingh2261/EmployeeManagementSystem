var counter1=0;
var counter2=0;
var counter3=0;
var counter4=0;

var counter5=0;
var counter6=0;
var counter7=0;
var counter8=0;




$('#1').on('scroll', function() {
    let div = $(this).get(0);
    let id = div.id;
    debugger
    if(div.scrollTop + div.clientHeight >= div.scrollHeight-10) {
        appendData(id,"counter1",$('#1'));
    }
});
$('#2').on('scroll', function() {
    let div = $(this).get(0);
    let id = div.id;
    debugger
    if(div.scrollTop + div.clientHeight >= div.scrollHeight-10) {
        appendData(id,"counter2",$('#2'));
    }
});
$('#3').on('scroll', function() {
    let div = $(this).get(0);
    let id = div.id;
    debugger
    if(div.scrollTop + div.clientHeight >= div.scrollHeight-10) {
        appendData(id,"counter3",$('#3'));
    }
});

$('#4').on('scroll', function() {
    let div = $(this).get(0);
    let id = div.id;
    debugger
    if(div.scrollTop + div.clientHeight >= div.scrollHeight-10) {
        appendData(id,"counter4",$('#4'));
    }
});



$('#10').on('scroll', function() {
    let div = $(this).get(0);
    let id = div.id;
    debugger
    if(div.scrollTop + div.clientHeight >= div.scrollHeight-10) {
        appendDeptData(id,"counter5",$('#10'));
    }
});
$('#20').on('scroll', function() {
    let div = $(this).get(0);
    let id = div.id;
    debugger
    if(div.scrollTop + div.clientHeight >= div.scrollHeight-10) {
        appendDeptData(id,"counter6",$('#20'));
    }
});
$('#30').on('scroll', function() {
    let div = $(this).get(0);
    let id = div.id;
    debugger
    if(div.scrollTop + div.clientHeight >= div.scrollHeight-10) {
        appendDeptData(id,"counter7",$('#30'));
    }
});

$('#40').on('scroll', function() {
    let div = $(this).get(0);
    let id = div.id;
    debugger
    if(div.scrollTop + div.clientHeight >= div.scrollHeight-10) {
        appendDeptData(id,"counter8",$('#40'));
    }
   
});








function appendData(id,counter,div) {
	$.ajax({
    url : "get_child?currLevel="+id+"&currLimit="+window[counter],
    type : "POST",
    success : function(data) {
        let userData = null;
            try {
    		userData = JSON.parse(data); 
			} catch (e) {
			    
			    userData = data;
			}
			console.log(counter4)
		
		var html = '';
	    for (i = 0; i<userData.allList.length; i++) {
	        html += '<br><box-el name='+userData.allList[i]['name']+'></box-el><br>';
	    }
	    div.append(html);
		window[counter]+=1;
		
	    }
});
}


function appendDeptData(id,counter,div) {
	
	$.ajax({
    url : "get_child?currLevel="+Math.floor(id/10)+"&currLimit="+window[counter],
    type : "POST",
    success : function(data) {
        let userData = null;
            try {
    		userData = JSON.parse(data); 
			} catch (e) {
			    
			    userData = data;
			}
			window[counter]+=1;
			console.log(userData.allList)
				
		if (parseInt(id)<40){
			for (j = 0; j<userData.allList.length; j++) {
				if(!(arr.includes(userData.allList[j]['departmentName']+userData.allList[j]['level']))){
					arr.push(userData.allList[j]['departmentName']+userData.allList[j]['level'])
					console.log(arr);
					
					$('#'+id).append('<div class ="container" id ='+userData.allList[j]['departmentName']+userData.allList[j]['level']+
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
					
					$('#'+id).append('<div class ="container" id ='+userData.allList[j]['departmentName']+userData.allList[j]['level']+
					'><br><dept-el id = '+userData.allList[j]['id']+
					' deptname='+userData.allList[j]['departmentName']+
					' name ='+userData.allList[j]['name']+
					' role="Member: "></dept-el><br></div>');		
					$('.container').sortable({});			
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