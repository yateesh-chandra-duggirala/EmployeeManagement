import Swal from "sweetalert2";

class SweetAlertComponent{

    addSuccess(){
        Swal.fire({
            title : "Employee Added Successfully",
            icon : "success",
            timer : 2000,
            timerProgressBar : true,
            showConfirmButton : false,
        })
    }

    updateSuccess(){
        Swal.fire({
            title : "Employee Updated Successfully",
            icon : "success",
            timer : 2000,
            timerProgressBar : true,
            showConfirmButton : false,
        })
    }

    errorCredentials(){
        Swal.fire({
            title : "Error Credentials detected",
            icon : "error",
            timer : 2000,
            timerProgressBar : true,
            confirmButtonText : "Modify",
        })
    }

    alreadyExists(tag){
        Swal.fire({
            title : tag,
            icon : "error",
            confirmButtonText: "Change"
        })
    }
}
// eslint-disable-next-line 
export default new SweetAlertComponent();