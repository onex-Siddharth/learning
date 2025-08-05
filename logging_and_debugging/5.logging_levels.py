import logging

logging.basicConfig(
    level=logging.DEBUG,
    format="%(asctime)s - %(levelname)s - %(message)s"
)

def authenticate(user, password):
    logging.info("Authenticating user: %s", user)
    if not user:
        logging.warning("Username is empty.")
        return False
    if password == "admin123":
        logging.debug("Password matched for user %s", user)
        return True
    logging.error("Authentication failed for user %s", user)
    return False

authenticate("alice", "admin123")
authenticate("", "123")
authenticate("bob", "wrongpass")
