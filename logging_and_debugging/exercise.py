import logging
logger = logging.getLogger()
logger.setLevel(logging.DEBUG)  


formatter = logging.Formatter('%(asctime)s - %(levelname)s - %(message)s')

file_handler = logging.FileHandler('transaction.log')
file_handler.setLevel(logging.DEBUG)
file_handler.setFormatter(formatter)

console_handler = logging.StreamHandler()
console_handler.setLevel(logging.INFO)
console_handler.setFormatter(formatter)


logger.addHandler(file_handler)
logger.addHandler(console_handler)

def parse_transactions(raw_data):
    transactions = []
    for i, record in enumerate(raw_data):
        parts = record.split(",")
        try:
            if len(parts) < 4:
                raise ValueError("Missing fields")

            date = parts[0].strip()
            amount_str = parts[1].strip()
            amount = float(amount_str) if amount_str else 0.0
            txn_type = parts[2].strip().lower()
            description = parts[3].strip()

            transaction = {
                "date": date,
                "amount": amount,
                "type": txn_type,
                "description": description
            }
            transactions.append(transaction)

        except Exception as e:
            logging.warning(f"Skipping record {i} due to error: {e} | Raw data: {record}")
    return transactions


def calculate_balance(transactions):
    balance = 0
    for txn in transactions:
        if txn["type"] == "credit":
            balance += txn["amount"]
        elif txn["type"] == "debit":
            balance -= txn["amount"]
        else:
            logging.debug(f"Unknown transaction type: {txn['type']}")
    return round(balance, 2)


def generate_summary(transactions):
    credit_txns = [t for t in transactions if t["type"] == "credit"]
    debit_txns = [t for t in transactions if t["type"] == "debit"]

    credit_count = len(credit_txns)
    debit_count = len(debit_txns)
    average_credit = (
        sum(t["amount"] for t in credit_txns) / credit_count
        if credit_count > 0 else 0.0
    )

    try:
        largest_txn = max(transactions, key=lambda t: t["amount"])
    except ValueError:
        largest_txn = None

    summary = {
        "credits": credit_count,
        "debits": debit_count,
        "average_credit": round(average_credit, 2),
        "largest_txn": largest_txn
    }
    return summary



def main():
    raw_data = [
        "2025-07-01, 1200, CREDIT, Salary",
        "2025-07-02, 300, debit, Grocery",
        "2025-07-03, , debit, Restaurant",          # Missing amount
        "2025-07-04, 200, DEBIT",                   # Missing description
        "2025-07-05, 400, credit, Freelance, Bonus" # Extra field
    ]

    transactions = parse_transactions(raw_data)
    logging.info(f"Parsed {len(transactions)} valid transactions.")

    balance = calculate_balance(transactions)
    logging.info(f"Final balance calculated: ₹{balance}")

    summary = generate_summary(transactions)
    logging.info("Generated transaction summary.")

    print("\n=== Transaction Summary ===")
    print(f"Final Balance: ₹{balance}")
    print(f"Credits: {summary['credits']}")
    print(f"Debits: {summary['debits']}")
    print(f"Average Credit: ₹{summary['average_credit']}")
    if summary["largest_txn"]:
        print(f"Largest Transaction: {summary['largest_txn']['description']} - ₹{summary['largest_txn']['amount']}")
    else:
        print("Largest Transaction: None")


if __name__ == "__main__":
    main()
