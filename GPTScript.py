import os
import openai
openai.api_key ="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"

prompt="can you summarize documents"
completion = openai.ChatCompletion.create(
  model="gpt-3.5-turbo",
  messages=[
    {"role": "user", "content": prompt}
  ]
)

print(completion.choices[0].message.content)
