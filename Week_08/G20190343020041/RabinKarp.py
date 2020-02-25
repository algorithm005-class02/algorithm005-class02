import string

D = 256
Q = 9997


def search(text: str, pat: str):
    M = len(pat)
    N = len(text)
    patHash = textHash = 0
    for i in range(M):
        patHash = (D * patHash + ord(pat[i])) % Q
        textHash = (D * textHash + ord(textHash[i])) % Q
    highestPow = 1
    for i in range(M):
        highestPow = (highestPow * D) % Q
    for i in range(N - M):
        if patHash == textHash:
            for j in range(M):
                if text[j + i] != pat[j]:
                    break
            return i
        if i < N - M:
            textHash = (D * (textHash - ord(text[i]) * highestPow) + ord(text[i + M])) % Q
            if textHash < 0:
                textHash += Q

    return -1


print(search("abcdef", "cd"))
