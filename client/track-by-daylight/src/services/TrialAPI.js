const tricky = `${process.env.REACT_APP_TRICKY_URL}`
const url = `${process.env.REACT_APP_API_URL}`

// export async function findTrialByUserId(id){
//     const response = await fetch(`${url}/trials/${id}`);
//     if (response.status === 200) {
//       return response.json();
//     } else if (response.status === 404) {
//       return Promise.reject(`User id: ${id} could not be found.`);
//     } else {
//       return Promise.reject("Unexpected error, oops.");
//     }
//   }


  export async function findTrialByUsername(username){
    const jwtToken = localStorage.getItem("jwt_token");
    if (!jwtToken) {
      return Promise.reject("Unauthorized.")
    }
    
    const init = {
      headers: {
        "Authorization": "Bearer " + jwtToken
      }
    }

    const response = await fetch(`${url}/api/trials/account/${username}`, init);
    if (response.status === 200) {
      return response.json();
    } else if (response.status === 404) {
      return Promise.reject(`User name: ${username} could not be found.`);
    } else {
      return Promise.reject("Unexpected error, oops.");
    }
  }

 
  //find survivor by trial id
  export async function findSurvivorByTrialId(trialId){
    const jwtToken = localStorage.getItem("jwt_token");
    if (!jwtToken) {
      return Promise.reject("Unauthorized.")
    }
    
    const init = {
      headers: {
        "Authorization": "Bearer " + jwtToken
      }
    }


    const response = await fetch(`${url}/api/survivor/${trialId}`, init);
    if (response.status === 200) {
      return response.json();
    } else if (response.status === 404) {
      return Promise.reject(`Trial Id: ${trialId} could not be found.`);
    } else {
      return Promise.reject("Unexpected error, oops.");
    }
  }

  //find perks by survivor ID
  export async function findPerksBySurvivorId(survivorId){
    const jwtToken = localStorage.getItem("jwt_token");
    if (!jwtToken) {
      return Promise.reject("Unauthorized.")
    }
    
    const init = {
      headers: {
        "Authorization": "Bearer " + jwtToken
      }
    }


    const response = await fetch(`${url}/api/survivor/${survivorId}`, init);
    if (response.status === 200) {
      return response.json();
    } else if (response.status === 404) {
      return Promise.reject(`Trial Id: ${survivorId} could not be found.`);
    } else {
      return Promise.reject("Unexpected error, oops.");
    }
  }


  //find perks by killer ID

    
  //find killer by trial id
  export async function findKillerByTrialId(trialId){
    const jwtToken = localStorage.getItem("jwt_token");
    if (!jwtToken) {
      return Promise.reject("Unauthorized.")
    }
    
    const init = {
      headers: {
        "Authorization": "Bearer " + jwtToken
      }
    }



    const response = await fetch(`${url}/api/killer/${trialId}`, init);
    if (response.status === 200) {
      return response.json();
    } else if (response.status === 404) {
      return Promise.reject(`Trial Id: ${trialId} could not be found.`);
    } else {
      return Promise.reject("Unexpected error, oops.");
    }
  }
  