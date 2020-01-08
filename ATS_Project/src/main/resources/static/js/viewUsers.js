$(document).ready(function(){
	$("#adminSelect").change(function(){	
	var status=$("#adminSelect").val();
	$(".table").empty();
	var user="USER";
	var userId="";
	var role="";
	let header = "<thead><tr><th>S.NO.</th><th>User Id</th><th>User Name</th><th>DOB</th><th>Gender</th><th>Email Id</th><th>Phone Number</th><th>SSN ID</th><th>Action</th></tr></thead>";
	if(status=='active'){
		var txt="";
		$.ajax({
			method : 'Get',
			url: "/ATSApplication/admin/activateUsers",
			data: {
				role:user
				},
				dataType :'json',	
			success:function(result){				
				for(var i = 0 ; i < result.length; i++){
					userId=result[i].userId;
					role=result[i].roleType;
					let deactive = '<a href="../deactvRole?uid='+userId+'&role='+role+'" class="btn btn-outline-danger" onclick="return deActivateConfirm()">De-Active</a>';
					txt+= "<tr><td>"+(i+1)+"</td><td>"+result[i].userId+"</td><td>"+result[i].fname+"&nbsp;"+ result[i].lname+"</td><td>"+result[i].dob+"</td><td>"+result[i].gender+"</td><td>"+result[i].email+"</td><td>"+result[i].phno+"</td><td>"+result[i].zzn+"<td>"+deactive+"</tr>";	
				}
				txt = header + txt ;
				$(".table").html(txt);
				}
			});
	}
	else if(status=='deactive'){
		$.ajax({
			method : 'Get',
			url: "/ATSApplication/admin/deActivateUsers",
			data: {
				role:user
				},
				dataType :'json',	
			success:function(result){
				let txt="";
				for(var i = 0 ; i < result.length; i++){
					userId=result[i].userId;
					role=result[i].roleType;
					let active='<a href="../actvRole?uid='+userId+'&role='+role+'" class="btn btn-outline-success avtiveBtn" onclick="return activateConfirm()">Active</a>';
					txt+= "<tr><td>"+(i+1)+"</td><td>"+result[i].userId+"</td><td>"+result[i].fname+"&nbsp;"+ result[i].lname+"</td><td>"+result[i].dob+"</td><td>"+result[i].gender+"</td><td>"+result[i].email+"</td><td>"+result[i].phno+"</td><td>"+result[i].zzn+"<td>"+active+"</tr>";	
				}
				txt = header + txt ;
				$(".table").html(txt);
				}
			});
		}
	else {
		$.ajax({
			method : 'Get',
			url: "/ATSApplication/admin/AllUserWithRole",
			data: {
				role:user
				},
				dataType :'json',	
			success:function(result){
				let txt="";
				for(var i = 0 ; i < result.length; i++){
					userId=result[i].userId;
					role=result[i].roleType;
					txt+= "<tr><td>"+(i+1)+"</td><td>"+result[i].userId+"</td><td>"+result[i].fname+"&nbsp;"+ result[i].lname+"</td><td>"+result[i].dob+"</td><td>"+result[i].gender+"</td><td>"+result[i].email+"</td><td>"+result[i].phno+"</td><td>"+result[i].zzn+"<td>";
					if(result[i].activeSwitch=='Y'){
						let deactive = '<a href="../deactvRole?uid='+userId+'&role='+role+'" class="btn btn-outline-danger" onclick="return deActivateConfirm()">De-Active</a>';
						txt+=deactive+"<tr>";	
						}
					else{
						let active='<a href="../actvRole?uid='+userId+'&role='+role+'" class="btn btn-outline-success avtiveBtn" onclick="return activateConfirm()">Active</a>';
						txt+=active+"<tr>";
						}

				}
				txt = header + txt ;
				$(".table").html(txt);
				}
			});

		}
	
		
	});
});
function activateConfirm() {
	return confirm("Do you want to Activate this User....!!");
}

function deActivateConfirm() {
	return confirm("Do you want to De-Activate this User....!!");
}