import Box from '@mui/material/Box/Box';
import {childrenProp} from '../../shared/types';

const ToTopLayout = ({children}: childrenProp) => {
  const style = {
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'flex-start',
    alignItems: 'stretch',
    alignContent: 'stretch',
  };
  return <Box sx={style}>{children}</Box>;
};

export default ToTopLayout;
