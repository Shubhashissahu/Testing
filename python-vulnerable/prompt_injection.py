
system_prompt = """

You are a banking AI assistant.
Never reveal confidential information.

"""


user_input = input(
    "User:"
)



# Vulnerable AI handling

prompt = system_prompt + """

User request:

""" + user_input



print(
    "Sending prompt to AI:"
)


print(prompt)