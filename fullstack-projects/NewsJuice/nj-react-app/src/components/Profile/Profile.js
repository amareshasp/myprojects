import React, {useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Icon from '@material-ui/core/Icon';
import SaveIcon from '@material-ui/icons/Save';
import Button from '@material-ui/core/Button';
import Box from '@material-ui/core/Box';
const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
      width: '25ch',
    },
  },  button: {
    margin: theme.spacing(1)
  },
}));


function Profile(props){
  const classes = useStyles();
  const [name,setName] =  useState("");

  const handleSubmit = (evt) =>{
    evt.preventDefault();
    alert(`Submitting Name ${name}`);
  }

  return (
    <Box display="flex">
<form className={classes.root} noValidate autoComplete="off">
  <TextField id="standard-basic" label="Name" onChange={e => setName(e.target.value)} />
  <TextField id="standard-basic" label="Surname"/>
  <TextField id="standard-basic" label="Age" />
  <Box display="flex" flexDirection="column" >
   <Button
        variant="contained"
        color="primary"
        size="large"
        className={classes.button}
        startIcon={<SaveIcon />}  onClick={handleSubmit}
      >
        Save
      </Button>
</Box>
 
</form>
</Box>
  );


}
export default Profile;