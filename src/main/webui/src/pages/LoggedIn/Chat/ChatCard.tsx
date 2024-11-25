import Avatar from '@mui/material/Avatar';

export type ChatCardProps = {
  pathToAvatar?: string;
  nameOfUser: string;
  lastMessage: string;
};

const ChatCard = (props: ChatCardProps) => {
  const pathToAvatar = props.pathToAvatar && '';
  return (
    <div style={{display: 'flex', gap: '1rem'}}>
      {pathToAvatar ? (
        <Avatar alt={props.nameOfUser} src={pathToAvatar}></Avatar>
      ) : (
        <Avatar>
          {
            // getting first letters of name and surname
            props.nameOfUser.split(' ').map((val, index) => {
              if (index < 2) return val.toUpperCase().charAt(0);
            })
          }
        </Avatar>
      )}
      <div style={{display: 'flex', flexDirection: 'column'}}>
        <small>{props.nameOfUser}</small>
        <p>{props.lastMessage}</p>
      </div>
    </div>
  );
};
export default ChatCard;
