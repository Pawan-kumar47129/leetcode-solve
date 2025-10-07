class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String>set=new HashSet<>();
        for (String email : emails) {
            // Split into local and domain parts
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            // Remove everything after '+' in local part
            if (local.contains("+")) {
                local = local.split("\\+")[0];
            }

            // Remove dots in the local part
            local = local.replaceAll("\\.", "");

            // Combine processed local + domain
            String filteredEmail = local + "@" + domain;

            set.add(filteredEmail);
        }
        return set.size();
    }
}