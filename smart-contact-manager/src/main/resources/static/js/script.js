function deleteContact(id) {
	swal({
		title: "Are you sure you want to delete?",
		text: "Once deleted can not be recovered",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				window.location = "/user/contact/delete/"+id;
			} else {
				swal("Your imaginary file is safe!");
			}
		});
}