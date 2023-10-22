const tricky = `${process.env.REACT_APP_TRICKY_URL}`;
const url = `${process.env.REACT_APP_API_URL}`

export async function findTrialByUserId(id){
    const response = await fetch(`${url}/${id}`);
    if (response.status === 200) {
      return response.json();
    } else if (response.status === 404) {
      return Promise.reject(`User id: ${id} could not be found.`);
    } else {
      return Promise.reject("Unexpected error, oops.");
    }
  }
