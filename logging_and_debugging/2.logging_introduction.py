import logging

# Setup basic configuration
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s'
)

def process_data(data):
    logging.info("Starting process_data")
    if not data:
        logging.warning("No data provided.")
        return
    total = 0
    for i, item in enumerate(data):
        logging.debug(f"Processing item {i}: {item}")
        total += item
    logging.info(f"Total: {total}")
    return total

process_data([1, 2, 3])
process_data([])
