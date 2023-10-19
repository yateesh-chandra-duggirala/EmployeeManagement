import axios from "axios";


const baseURL = "http://localhost:8081/employee";


class Service{
    fetchEmployees(){
         return axios.get(baseURL);
    }

    addEmployee(data){
        return axios.post(baseURL, data);
    }

    deleteEmployee(id){
        return axios.delete(baseURL + "/" + id);
    }

    updateEmployee(id, data){
        return axios.put(baseURL + "/" + id, data);
    }

    fetchEmployeeById(id){
        return axios.get(baseURL + "/" + id);
    }
}

// eslint-disable-next-line 
export default new Service();