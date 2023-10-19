import React, { useEffect, useState } from "react";
import Service from "../Services/Service";
import { useNavigate } from "react-router-dom";
import Swal from "sweetalert2";

const Employee = () => {

    const [employee, setEmployee] = useState([]);
    const navigate = useNavigate();

    useEffect (() =>{
        getEmployees();
    }, [])

    const getEmployees = async() => {
        try{
            await Service.fetchEmployees().then((response) =>{
            console.log(response);
            setEmployee(response?.data?.body);
        })}
        catch(error){
            console.log(error);
        }
    }

    const deleteAction = (employeeId) => {
        Swal.fire({
            title : "Delete Employee?",
            text : "This can not be undone",
            confirmButtonText : "Delete",
            showCancelButton : true,
            cancelButtonText : "Cancel",
            icon : "warning",
        }).then((response) => {
            if(response.isConfirmed){
                Service.deleteEmployee(employeeId).then(() => getEmployees());
            }
        })
    }

    const updateAction = (employeeId) => {
        navigate(`/add/${employeeId}`);
    }

    return(
        <div className="App">
            <h1>Employee Management</h1>
            <button className="add-employee" onClick={() => navigate("/add")}>Add Employee</button>
            {employee.length > 0 ? 
            <div className="table-center">
            <table className="table-container">
                <thead>
                    <th>Employee Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email Id</th>
                    <th>Actions</th>
                </thead>
                <tbody>
                    {employee.map((emp) =>(
                        <tr key = {emp.employeeId}>
                            <td>{emp.employeeId}</td>
                            <td>{emp.firstName}</td>
                            <td>{emp.lastName}</td>
                            <td>{emp.emailId}</td>
                            <td>
                                <div className="button-table-container">
                                    <button className="delete-button" onClick={() => deleteAction(emp.employeeId)}>Delete</button>
                                    <button className="update-button" onClick={() => updateAction(emp.employeeId)}>Update</button>
                                </div>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            </div>
            :<div className="App">
                <p>No Employees Found</p>
            </div>}
        </div>
    );
}

export default Employee;