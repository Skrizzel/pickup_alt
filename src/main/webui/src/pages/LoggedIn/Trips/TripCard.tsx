import Avatar from '@mui/material/Avatar';

export type TripCardProps = {
  pathToAvatar?: string;
  date: Date;
  nameOfDriver: string;
  from: string;
  to: string;
};

const TripCard = (props: TripCardProps) => {
  const pathToAvatar = props.pathToAvatar && '';

  return (
    <div style={{display: 'flex', gap: '1rem'}}>
      <div style={{display: 'flex', alignItems: 'center'}}>
        {pathToAvatar ? (
          <Avatar alt={props.nameOfDriver} src={pathToAvatar}></Avatar>
        ) : (
          <Avatar>
            {
              // getting first letters of name and surname
              props.nameOfDriver.split(' ').map((val, index) => {
                if (index < 2) return val.toUpperCase().charAt(0);
              })
            }
          </Avatar>
        )}
      </div>
      <div>
        <p>
          <small>
            {props.date.toLocaleDateString()}, {props.nameOfDriver}
          </small>
        </p>
        <p>Von: {props.from}</p>
        <p>Nach: {props.to}</p>
      </div>
    </div>
  );
};
export default TripCard;
