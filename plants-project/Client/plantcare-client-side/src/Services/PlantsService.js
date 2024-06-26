// // PlantsService.js
//
// import axios from 'axios';
//
// const api = axios.create({
//     baseURL: "http://localhost:3000"
// });
//
// const fetchPlants = async () => {
//     try {
//         const response = await api.get('/plants');
//         return response.data;
//     } catch (error) {
//         console.error('Error fetching plants:', error);
//         throw error;
//     }
// };
//
// export default fetchPlants;
