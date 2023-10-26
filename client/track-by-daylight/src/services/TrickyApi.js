
const tricky = `${process.env.REACT_APP_TRICKY_URL}`
const token = `${process.env.REACT_APP_TRICKY_TOKEN}`


export async function findMapByName(realmName) {


  const init = {
    headers: {
      Accept: "application/json",
      
    },
  }

    const response = await fetch(`${tricky}/?toSearch=mapinfo?map=${realmName}`, init);
    if (response.status === 200) {
      return response.json();
    } else if (response.status === 404) {
      return Promise.reject(`map: ${realmName} could not be found.`);
    } else {
      return Promise.reject("Unexpected error, oops.");
    }

  }

  export async function findSurvivorByName(survivorName){

    
  const init = {
    headers: {
      Accept: "application/json",
      
    },
  }

    const response = await fetch(`${tricky}/survivorName/?toSearch=characterinfo?character=${survivorName}`, init);
    if (response.status === 200) {
      return response.json();
    } else if (response.status === 404) {
      return Promise.reject(`survivor: ${survivorName} could not be found.`);
    } else {
      return Promise.reject("Unexpected error, oops.");
    }

  }

  export async function findKillerByName(killerName){

    
    const init = {
      headers: {
        Accept: "application/json",
        
      },
    }
  
      const response = await fetch(`${tricky}/killerName/?toSearch=characterinfo?character=${killerName}`, init);
      if (response.status === 200) {
        return response.json();
      } else if (response.status === 404) {
        return Promise.reject(`survivor: ${killerName} could not be found.`);
      } else {
        return Promise.reject("Unexpected error, oops.");
      }
  
    }
