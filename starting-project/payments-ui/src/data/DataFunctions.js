import axios from 'axios';

export const getAllPaymentsForCountry = (country) => {
    const transactionsPromise = axios({url : `http://localhost:8080/api/payments?country=${country}`, method: "GET", headers : {'Accept': 'application/json'} });
    return transactionsPromise;
}

export const getAllPaymentsForOrderId = (orderId) => {
    const transactionsPromise = axios({url : `http://localhost:8080/api/payments?order=${orderId}`, method: "GET", headers : {'Accept': 'application/json'} });
    return transactionsPromise;
}

export const getCountries = () => {
    return axios.request({url : "http://localhost:8080/api/country", method: "GET", headers : {'Accept': 'application/json'} });
}

export const addNewTransaction = (payment) => {
    return axios({url : "http://localhost:8080/api/payments",
        method: "POST",
        headers : {'Accept': 'application/json', 'Content-Type' : 'application/json'},
        data: payment});
}
