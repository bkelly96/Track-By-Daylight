const tricky = `${process.env.REACT_APP_TRICKY_URL}`
const token = `${process.env.REACT_APP_TRICKY_TOKEN}`


export async function findMapByName(realmName) {

  const init = {
    headers: {
      Accept: "application/json",
      "Access-Control-Allow-Origin": "https://dbd.tricky.lol",
      Authorization: "Bearer  " + token,
    },
  }

    const response = await fetch(`${tricky}/mapinfo?map=${realmName}`, init);
    if (response.status === 200) {
      return response.json();
    } else if (response.status === 404) {
      return Promise.reject(`map: ${realmName} could not be found.`);
    } else {
      return Promise.reject("Unexpected error, oops.");
    }
  }