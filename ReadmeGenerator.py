import os

# Path to the root directory
root_dir = '.'

# Name of the parent README file
parent_readme = 'README.md'

# Recursive function to generate links for subfolders
def generate_links(folder, level=0):
    content = ""
    indent = "  " * level  # Indentation for nested folders
    for item in sorted(os.listdir(folder)):
        item_path = os.path.join(folder, item)
        readme_path = os.path.join(item_path, 'README.md')

        if os.path.isdir(item_path):
            # Check if the directory contains a README.md
            if os.path.exists(readme_path):
                relative_path = os.path.relpath(item_path, root_dir)
                content += f"{indent}- [{item}]({relative_path}/)\n"

            # Recursively handle subfolders
            subfolder_content = generate_links(item_path, level + 1)
            if subfolder_content:
                content += subfolder_content
    return content

# Generate the content for the parent README
def generate_readme_content(root_dir):
    content = "# My Multi-Framework Repository\n\n"
    content += "Welcome to my repository! Below are the projects available:\n\n"
    content += "## Projects\n\n"
    content += generate_links(root_dir)
    content += "\n## How to Use This Repository\n\n"
    content += "1. Navigate to the folder of your choice by clicking the links above.\n"
    content += "2. Each folder contains its own `README.md` with setup and usage instructions.\n"
    return content

# Write the content to the parent README
def update_parent_readme(root_dir, parent_readme):
    content = generate_readme_content(root_dir)
    with open(parent_readme, 'w') as f:
        f.write(content)
    print(f"{parent_readme} has been updated!")

# Run the script
update_parent_readme(root_dir, parent_readme)
