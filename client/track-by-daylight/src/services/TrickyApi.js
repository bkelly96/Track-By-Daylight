const tricky = `${process.env.REACT_APP_TRICKY_URL}`;


export async function findMapByName(mapName) {
    const response = await fetch(`${tricky}/${mapName}`);
    if (response.status === 200) {
      return response.json();
    } else if (response.status === 404) {
      return Promise.reject(`map: ${mapName} could not be found.`);
    } else {
      return Promise.reject("Unexpected error, oops.");
    }
  }