import React, { useEffect, useState } from "react";
import Service from "../Services/Service";
import { useNavigate, useParams } from "react-router-dom";
import SweetAlertComponent from "./SweetAlertComponent";

const AddOrUpdateEmployee = () => {

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [emailId, setEmailId] = useState('');

    const [firstNameError, setFirstNameError] = useState("");
    const [lastNameError, setLastNameError] = useState("");
    const[emailIdError, setEmailIdError] = useState("");

    const navigate = useNavigate();

    const {employeeId} = useParams();
    const isUpdating = employeeId !== undefined;

    useEffect(() => {
        if(isUpdating){
            fetchEmployeeData();
        }
    // eslint-disable-next-line 
    },[]);

    const fetchEmployeeData = async() => {
        await Service.fetchEmployeeById(employeeId)
        .then((response) => {
            const {firstName, lastName, emailId} = response.data.body;
            setFirstName(firstName);
            setLastName(lastName);
            setEmailId(emailId);
        })
    }

    const handleFirstNameChange = (e) => {
        const validName = e.target.value;
        setFirstName(validName);
        if(!validName){
            setFirstNameError("Enter Valid First Name");
        } else {
            setFirstNameError("");
        }
    };

    const handleLastNameChange = (e) => {
        const validName = e.target.value;
        setLastName(validName);
        if(!validName){
            setLastNameError("Enter Valid Last Name");
        }
        else{
            setLastNameError("");
        }
    };

    const handleEmailChange = (e) => {
        const validEmail = e.target.value;
        setEmailId(validEmail);
        if(!validEmail){
            setEmailIdError("Enter Valid Email");
        } else {
            setEmailIdError("");
        }
    };

    const validForm = () => {
        let isValid = true;
        if(!firstName){
            setFirstNameError("Enter first Name");
            isValid = false;
        } else if(firstName.startsWith(" ")){
            setFirstNameError("Name cannot start with white Spaces");
            isValid = false;
        } else {
            setFirstNameError("");
        }

        if(!lastName){
            setLastNameError("Enter last Name");
            isValid = false;  
        } else if(lastName.startsWith(" ")){
            setLastNameError("Name cannot start with white Spaces");
            isValid = false;
        } else {
            setLastNameError("");
        }

        if(!emailId){
            setEmailIdError("Enter Email Address");
            isValid = false;
            // eslint-disable-next-line 
    	} else if(!/^[\w\.-]+@[a-zA-Z\d\.-]+\.[a-zA-Z]{2,}$/.test(emailId)){
            setEmailIdError("Invalid email pattern");
            isValid = false;
        } else {
            setEmailIdError("");
        }
        return isValid;
    };

    const updateOrAddEmployee = async(e) =>{
        e.preventDefault();

        if(!validForm()){
            SweetAlertComponent.errorCredentials();
            return;
        }
        
        const data = {
            firstName,
            lastName,
            emailId,
        }
        
        if(isUpdating){
            try{
                await Service.updateEmployee(employeeId, data);
                SweetAlertComponent.updateSuccess();
                navigate("/");
            } catch(error){
                console.log(error)
                SweetAlertComponent.alreadyExists(error.response.data.message);
            }
        } else {
            try{
                await Service.addEmployee(data);
                SweetAlertComponent.addSuccess();
                navigate("/");
            } catch(error){
                SweetAlertComponent.alreadyExists(error.response.data.message);
                console.log(error);
            }
        }
    }

    return(
        <div>
            <div className="table-center">
                <form onSubmit={updateOrAddEmployee} className="container">
                    <h1>{isUpdating ? "Update Employee" : "Add Employee"}</h1>
                    <div className="form-group">
                        <label>First Name</label>
                        <input
                         type="text"
                         value={firstName}
                         className="input-field"
                         onChange={handleFirstNameChange}
                        />
                        {firstNameError && <div className="error">{firstNameError}</div>}
                    </div>
                    <div className="form-group">
                        <label>Last Name</label>
                        <input 
                         type="text"
                         value={lastName}
                         className="input-field"
                         onChange={handleLastNameChange}
                        />
                        {lastNameError && <div className="error">{lastNameError}</div>}
                    </div>
                    <div className="form-group">
                        <label>Email Id</label>
                        <input
                         type="email"
                         value={emailId}
                         className="input-field"
                         onChange={handleEmailChange}
                        />
                        {emailIdError && <div className="error">{emailIdError}</div>}
                    </div>
                    <div className="button-container">
                        <button className="add-button" onClick={updateOrAddEmployee}>{isUpdating ? "Update" : "Add"}</button>
                        <button className="delete-button" onClick={() => navigate("/")}>Cancel</button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default AddOrUpdateEmployee;