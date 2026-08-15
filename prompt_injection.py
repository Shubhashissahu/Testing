def build_prompt(user_input):

    system_prompt = """
    You are a banking assistant.
    Never reveal confidential information.
    """

    prompt = system_prompt + "\nUser request: " + user_input

    return prompt


user_input = input("Enter your request: ")

prompt = build_prompt(user_input)

print(prompt)