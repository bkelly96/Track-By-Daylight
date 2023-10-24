import { useState } from 'react';

function TrickyForm() {

  const [trickyUrl, setTrickyUrl] = useState();

  const uploadFile = async (evt) => {
    const formData = new FormData();   
    formData.append('type', 'file');
    formData.append('image', evt.target.files[0]);

    const response = await fetch('http://localhost:8080/api/image/upload', {
      method: 'GET',
      headers: {
        Accept: 'application/json'
      },
      body: formData
    });

    const data = await response.json();

    if (data.success) {

        setTrickyUrl(data.link);

    } else {
      console.log(data);
    }
  };

  return <>
    <input type="file" onChange={uploadFile}></input>
    {!!trickyUrl && <img src={trickyUrl} />}
  </>
}

export default TrickyForm;